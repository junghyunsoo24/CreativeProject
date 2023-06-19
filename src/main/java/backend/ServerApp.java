package backend;

import backend.Server.Server;

public class ServerApp {
    public static void main(String[] args) {
        Server server = new Server("192.168.0.3", 3000);
        server.run();
    }
}
