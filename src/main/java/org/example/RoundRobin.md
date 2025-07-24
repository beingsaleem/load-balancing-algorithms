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