package persistence;

import Control.DBControl;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;

public class DBConnectionTest {
    public static void main(String[] args) throws IOException, CsvException, InvalidNameFormatException {
        DBControl db = new DBControl();
        db.DBUpdateRequest(new File("src/main/java/법정동별 일평균 유동인구 데이터_202001.csv"));
    }
}
