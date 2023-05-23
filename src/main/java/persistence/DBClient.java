package persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import persistence.DTO.DTO;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class DBClient {
    private final String HOST;
    private final int PORT;
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private static final Logger log = LoggerFactory.getLogger(DBClient.class);

    public DBClient(String host, int port) {
        HOST = host;
        PORT = port;

        try {
            log.info("DBClient 실행");
            socket = new Socket(HOST, PORT);
            log.info("소켓 생성됨");
            oos = new ObjectOutputStream(this.socket.getOutputStream());
            ois = new ObjectInputStream(this.socket.getInputStream());
            log.info("스트림 생성됨");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DBUpdateRequest(File csv) throws IOException {
        Protocol<File> protocol = new Protocol<>(ProtocolQuery.insert, ProtocolType.insert, csv);
        oos.writeObject(protocol);
    }

    public List<DTO> selectRequest(ProtocolQuery query, ProtocolType type) throws IOException, ClassNotFoundException {
        Protocol<File> protocol = new Protocol<>(query, type, null);
        oos.writeObject(protocol);

        Protocol<List<DTO>> response = (Protocol<List<DTO>>) ois.readObject();
        return response.getDATA();
    }
}
