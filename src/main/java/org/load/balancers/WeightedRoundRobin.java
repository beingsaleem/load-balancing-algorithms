package org.load.balancers;

import java.util.*;

public class WeightedRoundRobin {

    String[] servers;
    int[] weights;
    int currentIndex;
    int currentWeight;

    public WeightedRoundRobin(String[] servers, int[] weights) {
        this.servers = servers;
        this.weights = weights;
        currentIndex = -1;
        currentWeight = -1;
    }

    public String getNextServer() {
        while (true) {
            currentIndex = (currentIndex + 1) % servers.length;
            if (currentIndex == 0) {
                currentWeight--;
                if (currentWeight <= 0) {
                    currentWeight = Arrays.stream(weights).max().getAsInt();
                }
            }
            if (weights[currentIndex] >= currentWeight)
                return servers[currentIndex];
        }
    }
}
