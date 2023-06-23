package backend;

import backend.Server.Server;

public class ServerApp {
    public static void main(String[] args) {
// Server server = new Server("192.168.0.3", 3000); //개인 장비로 실행시킬리면 localhost를 이용하면됨
        Server server = new Server("localhost", 3000);

        server.run();
    }
}
