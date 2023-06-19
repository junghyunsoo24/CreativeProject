package backend.Server;

import com.opencsv.exceptions.CsvException;
import backend.DB.DTO.AdminDTO;
import backend.DB.DTO.DTO;
import backend.DB.Protocol.Protocol;
import backend.DB.Protocol.ProtocolQuery;
import backend.DB.Protocol.ProtocolType;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ServerThread implements Runnable {
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    public ServerThread(Socket socket) {
        this.socket = socket;
        try {
            oos = new ObjectOutputStream(this.socket.getOutputStream());
            ois = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Protocol<?> protocol;
        
        try {
            while (true) {
                protocol = (Protocol<?>) ois.readObject();
                System.out.println("프로토콜 전달 받음");
                execute(protocol);
                System.out.println("명령 수행 완료");
            }
        } catch (SocketException e) {
            //pass
        } catch (InvalidNameFormatException | IOException | CsvException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void execute(Protocol<?> protocol) throws InvalidNameFormatException, IOException, CsvException {
        ServerControl control = new ServerControl();

        if (protocol.getQUERY() == ProtocolQuery.insert) {
            System.out.println("DB INSERT 명령 확인");
            control.DBUpdateRequest((File) protocol.getDATA());
            System.out.println("DB INSERT 완료");
        } else if (protocol.getQUERY() == ProtocolQuery.findByIdAndPassword) {
            System.out.println("관리자 검증 명령 확인");
            Boolean data = control.findByIdAndPassword((AdminDTO) protocol.getDATA());
            Protocol<Boolean> responseProtocol = new Protocol<>(ProtocolQuery.response, ProtocolType.response, data);
            oos.writeObject(responseProtocol);
            System.out.println("관리자 검증 완료");
        } else if (protocol.getQUERY() == ProtocolQuery.selectSum) {
            System.out.println("SUM 명령 확인");
            Long sum = control.selectSumRequest(protocol);
            Protocol<Long> responseProtocol = new Protocol<>(ProtocolQuery.response, ProtocolType.response, sum);
            oos.writeObject(responseProtocol);
            System.out.println("SUM 반환 완료");
        } else {
            System.out.println("DB SELECT 명령 확인");
            Protocol<List<DTO>> responseProtocol;
            List<DTO> data = null;

            if (protocol.getQUERY() == ProtocolQuery.selectAll) {
                data = control.selectAllRequest(protocol);
            } else if (protocol.getQUERY() == ProtocolQuery.selectOrderByMonth) {
                data = control.selectOrderByMonthRequest(protocol);
            } else if (protocol.getQUERY() == ProtocolQuery.selectOrderByDongName) {
                data = control.selectOrderByDongNameRequest(protocol);
            } else if (protocol.getQUERY() == ProtocolQuery.selectOrderByIndustryCode) {
                data = control.selectOrderByIndustryCodeRequest(protocol);
            } else if (protocol.getQUERY() == ProtocolQuery.selectOrderByAmount) {
                data = control.selectOrderByAmountRequest(protocol);
            } else if (protocol.getQUERY() == ProtocolQuery.selectOrderByDFP) {
                data = control.selectOrderByDFPRequest();
            }

            responseProtocol = new Protocol<>(ProtocolQuery.response, ProtocolType.response, data);
            oos.writeObject(responseProtocol);
            System.out.println("SELECT 완료");
        }
    }
}
