package Server.Host;

import java.net.InetAddress;

public abstract class HostAbstract implements Host {
    private final int ID;
    private final String ip;
    private final String name;

    public HostAbstract(int ID, String ip, String name) {
        this.ID = ID;
        this.ip = ip;
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){

    }

    @Override
    public String toString() {
        return "HostAbstract{" +
                "ID=" + ID +
                ", ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
