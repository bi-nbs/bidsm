package Server.Host;

import java.net.InetAddress;

public abstract class Host {
    private final int ID;
    private final InetAddress ip;

    public Host(int ID, InetAddress ip) {
        this.ID = ID;
        this.ip = ip;
    }
}
