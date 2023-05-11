package Entity;

import persistence.DAO.*;
import persistence.DTO.*;
import persistence.DTOListBuilder;
import persistence.InvalidNameFormatException;
import persistence.MyBatisConnectionFactory;
import com.opencsv.exceptions.CsvException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Data {
    private final File DATA;
    private final String NAME;

    public Data(File csv) {
        DATA = csv;
        NAME = DATA.getName();
    }

    @SuppressWarnings("unchecked")
    public void DBUpdate() throws IOException, CsvException, InvalidNameFormatException {
        DAO dao;
        List<DTO> list;

        if (NAME.contains("유성구_법정동별 소비금액 데이터")) {
            dao = new ConsumptionAmountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            list = new DTOListBuilder(DATA).CAListBuild();
        } else if (NAME.contains("유성구_외국인소비정보")) {
            dao = new ConsumptionAmountForeignerDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            list = new DTOListBuilder(DATA, "EUC-KR").CAFListBuild();
        } else if (NAME.contains("유성구_법정동별 외지인(내국인) 소비 금액 데이터")) {
            dao = new ConsumptionAmountOutsiderDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            list = new DTOListBuilder(DATA).CAOListBuild();
        } else if (NAME.contains("법정동별 일평균 유동인구 데이터")) {
            dao = new DailyFloatingPopulationDAO(MyBatisConnectionFactory.getSqlSessionFactory());
            list = new DTOListBuilder(DATA).DFPListBuild();
        } else {
            throw new InvalidNameFormatException("[치명적 오류] 파일 이름 형식이 잘못되었습니다.");
        }

        dao.insertAll(list);
    }
}
