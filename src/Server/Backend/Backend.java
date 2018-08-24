package Server.Backend;

import Server.Host.Host;

import java.util.List;

public interface Backend {

    public List<Host> getAllHosts();

    public void updateHost(Host host);
}
