package org.load.balancers;

import java.util.*;

public class LeastResponseTime {
    String[] servers;
    long[] responseTime;

    public LeastResponseTime(String[] servers) {
        this.servers = servers;
        this.responseTime = new long[servers.length];
    }

    public String getNextServer() {
        long minResponseTime = Arrays.stream(responseTime).min().getAsLong();

        List<String> minResponseServers = new ArrayList<>();
        for (int i = 0; i < servers.length; i++) {
            if (responseTime[i] == minResponseTime)
                minResponseServers.add(servers[i]);
        }

        return minResponseServers.get(new Random().nextInt(0, minResponseServers.size()));
    }

    public long getDelay() {
        long delay = new Random().nextLong(1, 1000);
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return delay;
    }

    public void updateResponseTime(String server, long time) {
        for (int i = 0; i < servers.length; i++) {
            if (servers[i].equals(server))
                responseTime[i] = time;
        }
    }

}
