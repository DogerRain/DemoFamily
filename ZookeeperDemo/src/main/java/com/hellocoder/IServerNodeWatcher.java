package com.hellocoder;

import java.util.List;

public interface IServerNodeWatcher {

    int getEvent();

    void childrenChanged(String path, List<String> children);

    void nodeDeleted(String path);

    void nodeDataChanged(String path);

    void nodeCreated(String path);
    /**成功连上ZooKeeper*/
    void connected();
}
