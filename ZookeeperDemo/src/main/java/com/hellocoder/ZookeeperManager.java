package com.hellocoder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

@Data
public class ZookeeperManager {

    public ZooKeeper zk;
    private String zkHosts="127.0.0.1:2181";
    private int timeout = 3000;



    private ConcurrentHashMap<String, CopyOnWriteArraySet<IServerNodeWatcher>> watchers = new ConcurrentHashMap<String, CopyOnWriteArraySet<IServerNodeWatcher>>();

    /**
     * 持续化监听
     *
     * @param path
     */
    public void addWatcher(String path, IServerNodeWatcher watcher) {

        int watcherEvent = watcher.getEvent();
        //选择自定义持续监听的逻辑,首次加入监听
        try {
            switch (watcherEvent) {
                case 1:
                    zk.getData(path, true, null);
                    break;
                default:
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        记录有哪些监听器
        CopyOnWriteArraySet<IServerNodeWatcher> existWatchs = watchers.get(path);
        if (existWatchs == null) {
            existWatchs = new CopyOnWriteArraySet<IServerNodeWatcher>();
            CopyOnWriteArraySet<IServerNodeWatcher> old = watchers.putIfAbsent(path, existWatchs);
            if (old != null) {
                existWatchs = old;
            }
        }
        existWatchs.add(watcher);

    }

    /**
     * 自定义监听要做些什么逻辑
     */
    public static class ZooKeeperWatcherAdapter implements IServerNodeWatcher {

        int eventType;

        public ZooKeeperWatcherAdapter(int eventType) {
            this.eventType = eventType;
        }

        @Override
        public int getEvent() {
            return eventType;
        }

        @Override
        public void childrenChanged(String path, List<String> children) {
        }

        @Override
        public void nodeDeleted(String path) {
        }

        @Override
        public void nodeDataChanged(String path) {
        }

        @Override
        public void nodeCreated(String path) {
        }

        @Override
        public void connected() {
        }
    }



    public void init() {
        ZooKeeper z = null;
        try {
            z = new ZooKeeper(zkHosts, timeout, new ZkWatcher());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(zk != null){
            try {
                zk.close();
            } catch (InterruptedException e) {
            }
        }
        zk = z;

    }


    private final class ZkWatcher implements Watcher {

        private  Logger log = LoggerFactory.getLogger(ZkWatcher.class);

        @Override
        public void process(WatchedEvent event) {
            String path = event.getPath();


            Event.KeeperState keeperState = event.getState();

            switch (keeperState) {
                case Disconnected:
                    log.info("zookeeper 断开连接，自动退出");
                case Expired:
                    int tries = 1;
                    while (tries <= 3) {
                        init();
                        log.info("zookeeper 超时，自动重连第 {} 次....", tries);
                        tries++;
                    }
                    break;
                case AuthFailed:
                case SyncConnected:


//                    取集合里面的监听器


                    log.info("SyncConnected");
                    Event.EventType eventType = event.getType();
                    switch (eventType) {
                        case None:
                            break;
                        case NodeDataChanged:
                            try {
                                if (path!=null){
                                    CopyOnWriteArraySet<IServerNodeWatcher> nodeWatchers = watchers.get(path);

                                }
//                                想要持续监听，需要在回调方法继续做监听
                                byte[] data = zk.getData(path, true, new Stat());
                                log.info("NodeDataChanged,path--->>>{},data--->>>{}", path, new String(data));
                            } catch (KeeperException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        default:
                    }
                    break;
                default:

            }


        }
    }
}
