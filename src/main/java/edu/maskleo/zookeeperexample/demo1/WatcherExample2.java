package edu.maskleo.zookeeperexample.demo1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class WatcherExample2 implements Watcher {

    private ZooKeeper zk;

    public WatcherExample2() {

    }

    public ZooKeeper getZk() {
        return zk;
    }

    public void setZk(ZooKeeper zk) {
        this.zk = zk;
    }

    @Override
    public void process(WatchedEvent event) {
        System.out.println("watcher=" + this.getClass().getName());
        System.out.println("path=" + event.getPath());
        System.out.println("eventType=" + event.getType().name());
        try {
            WatcherExample2 we2 = new WatcherExample2();
            we2.setZk(zk);
            zk.getData(event.getPath(), we2, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}