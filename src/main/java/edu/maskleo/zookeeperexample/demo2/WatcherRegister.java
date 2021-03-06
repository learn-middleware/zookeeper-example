package edu.maskleo.zookeeperexample.demo2;

import edu.maskleo.zookeeperexample.demo1.WatcherExample1;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class WatcherRegister {

    private ZooKeeper zk = null;

    public WatcherRegister(String connect, Watcher watcher) {
        try {
            zk = new ZooKeeper(connect, 10000, watcher);
            long sessionId = zk.getSessionId();
            byte[] sessionPwd = zk.getSessionPasswd();
            System.out.println(zk);
            Thread.sleep(300);
            zk = null;
            zk = new ZooKeeper(connect, 10000, watcher, sessionId, sessionPwd);
            System.out.println(zk);
            Thread.sleep(30000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WatcherExample1 we1 = new WatcherExample1();
        WatcherRegister wr = new WatcherRegister("127.0.0.1:2181", we1);
    }

}
