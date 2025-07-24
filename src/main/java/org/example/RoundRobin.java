package org.example;

public class RoundRobin {
    String[] servers;
    int currentServer;

    public RoundRobin(String[] servers) {
        this.servers = servers;
        this.currentServer = -1;
    }

    public String getNextServer() {
        currentServer = (currentServer + 1) % servers.length;
        return servers[currentServer];
    }
}
