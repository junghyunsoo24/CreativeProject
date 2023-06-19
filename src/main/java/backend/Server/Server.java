package backend.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class Server {
    private final String HOST;
    private final int PORT;
    private ServerSocket serverSocket;

    public Server(String host, int port) {
        HOST = host;
        PORT = port;
    }

    public void run() {
        System.out.println(LocalDateTime.now() + " ***** " + "DBServer 실행");
        try {
            System.out.println(LocalDateTime.now() + " ***** " + "서버 소켓 연결 시작");
            InetAddress ir = InetAddress.getByName(HOST);
            serverSocket = new ServerSocket(PORT, 50, ir);
            System.out.println(LocalDateTime.now() + " ***** " + "서버 소켓 연결 성공");

            while(true) {
                System.out.println(LocalDateTime.now() + " ***** " + "클라이언트 접속 대기 중");
                Socket socket = serverSocket.accept();
                ServerThread runnableObj = new ServerThread(socket);
                Thread DBThread = new Thread(runnableObj);
                DBThread.start();
                System.out.println(LocalDateTime.now() + " ***** " + "클라이언트 접속 감지");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
