package Entity;

import DB.DAO.ConsumptionAmountDAO;
import DB.DAO.ConsumptionAmountForeignerDAO;
import DB.DAO.ConsumptionAmountOutsiderDAO;
import DB.DAO.DailyFloatingPopulationDAO;
import DB.DTO.*;
import DB.MyBatisConnectionFactory;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public void DBUpdate(File csv) throws IOException, CsvException {
        String name  = csv.getName();
        if (name.contains("유성구_법정동별 소비금액 데이터")) {
            ConsumptionAmountDAO caDAO = new ConsumptionAmountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            List<ConsumptionAmountDTO> list = new DTOListBuilder(csv).CAListBuild();
            caDAO.insertAll(list);
        } else if (name.contains("유성구_외국인소비정보")) {
            ConsumptionAmountForeignerDAO cafDAO = new ConsumptionAmountForeignerDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            List<ConsumptionAmountForeignerDTO> list = new DTOListBuilder(csv).CAFListBuild();
            cafDAO.insertAll(list);
        } else if (name.contains("유성구_법정동별 외지인(내국인) 소비 금액 데이터")) {
            ConsumptionAmountOutsiderDAO caoDAO = new ConsumptionAmountOutsiderDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            List<ConsumptionAmountOutsiderDTO> list = new DTOListBuilder(csv).CAOListBuild();
            caoDAO.insertAll(list);
        } else if (name.contains("법정동별 일평균 유동인구 데이터")) {
            DailyFloatingPopulationDAO dfpDAO = new DailyFloatingPopulationDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            List<DailyFloatingPopulationDTO> list = new DTOListBuilder(csv).DFPListBuild();
            dfpDAO.insertAll(list);
        }
    }
}
