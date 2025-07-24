package org.example;

public class LoadBalancer {
    public static void main(String[] args) {
        String[] servers = {"server1", "server2", "server3", "server4"};

        RoundRobin roundRobin = new RoundRobin(servers);

        for (int i = 0; i < 10; i++) {
            System.out.print("request " + i + ": ");
            System.out.println(roundRobin.getNextServer());
        }
    }
}
