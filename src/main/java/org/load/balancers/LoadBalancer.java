package org.load.balancers;

public class LoadBalancer {
    public static void main(String[] args) {
        String[] servers = {"server1", "server2", "server3", "server4"};

        /*RoundRobin roundRobin = new RoundRobin(servers);

        for (int i = 0; i < 10; i++) {
            System.out.print("request " + i + ": ");
            System.out.println(roundRobin.getNextServer());
        }*/

        /*int[] weights = {2,5, 1, 1};

        WeightedRoundRobin loadBalancer = new WeightedRoundRobin(servers, weights);
        for (int i = 0; i < 10; i++) {
            System.out.print("request " + i + ": ");
            System.out.println(loadBalancer.getNextServer());
        }*/

        LeastConnections loadBalancer = new LeastConnections(servers);
        for (int i = 0; i < 10; i++) {
            System.out.print("request " + i + ": ");
            String nextServer = loadBalancer.getNextServer();
            System.out.println(nextServer);
            loadBalancer.releaseConnection(nextServer);
        }
    }
}
