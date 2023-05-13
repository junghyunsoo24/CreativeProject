package persistence;

import Control.DBUpdateControl;
import com.opencsv.exceptions.CsvException;
import persistence.DAO.ConsumptionAmountDAO;
import persistence.DTO.ConsumptionAmountDTO;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class DBConnectionTest {
    public static void main(String[] args) throws IOException, CsvException, InvalidNameFormatException {
        ConsumptionAmountDAO dao = new ConsumptionAmountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
        List<ConsumptionAmountDTO> list = dao.selectOrderByAmount();

        for (ConsumptionAmountDTO element : list) {
            System.out.println(element.toString());
        }
    }
}
