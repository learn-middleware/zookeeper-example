package edu.maskleo.zookeeperexample.demo1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class WatcherExample1 implements Watcher {


    private ZooKeeper zk;

    public WatcherExample1() {

    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("watcher=" + this.getClass().getName());
        System.out.println("path=" + event.getPath());
        System.out.println("eventType=" + event.getType().name());
    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }
}
