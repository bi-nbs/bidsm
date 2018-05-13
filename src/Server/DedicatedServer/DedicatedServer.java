package Server.DedicatedServer;

import java.net.InetAddress;

public abstract class DedicatedServer {

    private final String name;
    private final int ID;
    private final InetAddress ip;

    public DedicatedServer(String name, int ID, InetAddress ip) {
        this.name = name;
        this.ID = ID;
        this.ip = ip;
    }
}
