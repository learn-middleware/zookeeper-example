package edu.maskleo.zookeeperexample.demo1;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class WatcherRegister {

    private ZooKeeper zk = null;

    public WatcherRegister(String connect, Watcher watcher) {
        try {
            zk = new ZooKeeper(connect, 10000, watcher);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testWatcherdisabled(String path) throws KeeperException, InterruptedException {
        WatcherExample2 we2 = new WatcherExample2();
        we2.setZk(zk);
        zk.getData(path, we2, null);
    }

    public static void main(String[] args) {
        WatcherExample1 we1 = new WatcherExample1();
        WatcherRegister wr = new WatcherRegister("127.0.0.1:2181", we1);
        we1.setZk(wr.zk);
        try {
            wr.testWatcherdisabled("/zk1");
            Thread.sleep(30000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
