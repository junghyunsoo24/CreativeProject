package persistence;

import Control.DBControl;
import com.opencsv.exceptions.CsvException;
import persistence.DTO.DTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DBConnectionTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DBClient client = new DBClient("192.168.0.3", 3000);
        //client.DBUpdateRequest(new File("src/main/java/유성구_법정동별 소비금액 데이터_2020.csv"));
        List<DTO> list = client.selectRequest(ProtocolQuery.selectAll, ProtocolType.CA);
        for(DTO e : list) {
            System.out.println(e.toString());
        }

        while(true) {}
    }
}
