package persistence.Client;

import persistence.DTO.AdminDTO;
import persistence.DTO.DTO;
import persistence.Protocol.Protocol;
import persistence.Protocol.ProtocolQuery;
import persistence.Protocol.ProtocolType;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class DBClient {
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public DBClient(String host, int port) {
        try  {
            System.out.println("DBClient 실행");
            Socket socket = new Socket(host, port);
            System.out.println("소켓 생성됨");
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("스트림 생성됨");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void DBUpdateRequest(File csv) throws IOException {
        Protocol<File> protocol = new Protocol<>(ProtocolQuery.insert, ProtocolType.insert, csv);
        oos.writeObject(protocol);
        System.out.println("업데이트 요청 완료");
    }

    @SuppressWarnings("unchecked")
    public List<DTO> selectRequest(ProtocolQuery query, ProtocolType type) throws IOException, ClassNotFoundException {
        Protocol<File> protocol = new Protocol<>(query, type, null);
        oos.writeObject(protocol);
        System.out.println("SELECT 요청 완료");

        Protocol<List<DTO>> response = (Protocol<List<DTO>>) ois.readObject();
        return response.getDATA();
    }

    @SuppressWarnings("unchecked")
    public Boolean adminVerification(String id, String password) throws IOException, ClassNotFoundException {
        AdminDTO admin = new AdminDTO(id, password);
        Protocol<AdminDTO> protocol = new Protocol<>(ProtocolQuery.findByIdAndPassword, ProtocolType.admin, admin);
        oos.writeObject(protocol);
        System.out.println("관리자 검증 요청 완료");

        Protocol<Boolean> response = (Protocol<Boolean>) ois.readObject();
        return response.getDATA();
    }
}
