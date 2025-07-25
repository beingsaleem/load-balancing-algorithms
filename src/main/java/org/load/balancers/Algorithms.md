# Round Robin Algorithm

-------

- Servers are selected in a cyclic manner.
- Good to use when all the servers have similar processing capabilities.
- Ensures even distribution of traffic
- Does not consider server load or response time.
- Can lead to inefficiencies if servers have different processing capabilities.

Code:

```
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
```

# Weighted Round Robin

- Each server is assigned a weight based on their processing power or available resources.
- Servers with higher weights receive a proportionally larger share of incoming requests.
- Good to use when servers have different processing capabilities and want to distribute the load based on the capacity
  of each server.
- Drawbacks: slightly complex to implement, does not consider current load or response time.

```
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
```
