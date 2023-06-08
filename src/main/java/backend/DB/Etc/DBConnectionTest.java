package backend.DB.Etc;

import backend.DB.DBConnector;

import java.io.IOException;

public class DBConnectionTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DBConnector client = new DBConnector("localhost", 3000);
        //client.DBUpdateRequest(new File("src/main/java/유성구_법정동별 외지인(내국인) 소비 금액 데이터_2020.csv"));
        System.out.println(client.adminVerification("admin", "admin"));

//        List<DTO> list = client.selectRequest(ProtocolQuery.selectAll, ProtocolType.CA);
//        for(DTO e : list) {
//            System.out.println(e.toString());
//        }

        while(true) {}
    }
}
