package Server.Host;

import java.net.InetAddress;

public abstract class Host {
    private final int ID;
    private final InetAddress ip;
    private final String name;

    public Host(int ID, InetAddress ip, String name) {
        this.ID = ID;
        this.ip = ip;
        this.name = name;
    }
}
