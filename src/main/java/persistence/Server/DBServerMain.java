package persistence.Server;

public class DBServerMain {
    public static void main(String[] args) {
        DBServer server = new DBServer("localhost", 3000);
        server.run();
    }
}
