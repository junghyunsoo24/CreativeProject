package DB;

import Control.DBUpdateControl;
import DB.DAO.ConsumptionAmountDAO;
import DB.DTO.ConsumptionAmountDTO;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnectionTest {
    public static void main(String[] args) throws IOException, CsvException {
        DBUpdateControl control = new DBUpdateControl();
        control.DBUpdateRequest(new File("C:\\Users\\Han SeongMin\\IdeaProjects\\CreativeProject\\src\\main\\java\\Control\\유성구_법정동별 소비금액 데이터_2020.csv"));
    }
}
