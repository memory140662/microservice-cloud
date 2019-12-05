package com.demo.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class MyCustomRule extends AbstractLoadBalancerRule {

    private int total = 0;
    private int currentIndex = 0;

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        if (getLoadBalancer() == null) {
            return null;
        }

        ILoadBalancer lb = getLoadBalancer();

        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                return null;
            }

            server = upList.get(currentIndex);
            total++;

            if (total >= 5) {
                currentIndex = (currentIndex + 1) % upList.size();
                total = 0;
            }


            if (server == null) {
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }


        return server;
    }
}
