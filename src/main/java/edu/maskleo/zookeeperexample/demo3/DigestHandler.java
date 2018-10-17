package edu.maskleo.zookeeperexample.demo3;

import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

public final class DigestHandler {

    public static void main(String[] args) throws Exception {
        System.out.println(DigestAuthenticationProvider.generateDigest("admin:123456"));
    }

}
