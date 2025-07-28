package org.load.balancers;

import java.util.*;

public class LeastConnections {
    String[] servers;
    Map<String, Integer> connections = new HashMap<>();

    public LeastConnections(String[] servers) {
        this.servers = servers;
        for (String server : servers) {
            connections.put(server, 0);
        }
    }

    public String getNextServer() {
        int minConnections = Integer.MAX_VALUE;
        for (int value : connections.values()) {
            minConnections = Math.min(minConnections, value);
        }
        List<String> leastConnectionServers = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : connections.entrySet()) {
            if (entry.getValue() == minConnections)
                leastConnectionServers.add(entry.getKey());
        }
        int selectedServer = new Random().nextInt(0, leastConnectionServers.size());
        connections.put(leastConnectionServers.get(selectedServer), minConnections + 1);
        return leastConnectionServers.get(selectedServer);
    }

    public void releaseConnection(String server) {
        if (connections.containsKey(server) && connections.get(server) > 0)
            connections.put(server, connections.get(server) - 1);
    }

}
