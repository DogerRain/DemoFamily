import com.hellocoder.ZookeeperManager;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ZookeeperTest
{
    @Test
    public void test() throws KeeperException, InterruptedException, IOException {
        String path = "/common_string_zk";

        ZookeeperManager zookeeperManager = new ZookeeperManager();
        zookeeperManager.init();
        ZooKeeper zooKeeper = zookeeperManager.getZk();

        zookeeperManager.addWatcher(path, new ZookeeperManager.ZooKeeperWatcherAdapter(1));

        byte[] bytes = zooKeeper.getData(path, true, new Stat());


        System.out.println(new String(bytes));

        new CountDownLatch(1).await();
    }
}
