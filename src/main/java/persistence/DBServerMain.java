package persistence;

public class DBServerMain {
    public static void main(String[] args) {
        DBServer server = new DBServer("192.168.0.3", 3000);
        server.run();
    }
}
