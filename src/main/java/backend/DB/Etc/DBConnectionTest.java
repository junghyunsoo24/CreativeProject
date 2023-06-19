package backend.DB.Etc;

import backend.DB.DBConnector;

import java.io.File;
import java.io.IOException;

public class DBConnectionTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DBConnector client = new DBConnector("192.168.0.3", 3000);
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202201-202202.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202203.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202204.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202205.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202206.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202207.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202208.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202209.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202210.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202211.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 소비금액 데이터_20221231 (1)/유성구_법정동별 소비금액 데이터_202212.csv"));

        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_2022_01-03.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202204.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202205.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202206.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202207.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202208.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202209.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202210.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202211.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외국인 소비 금액 데이터_20221231 (1)/유성구_외국인소비정보_202212.csv"));

        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202201-202202.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202203.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202204.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202205.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202206.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202207.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202208.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202209.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202210.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202211.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 외지인(내국인) 소비 금액 데이터_20221231/유성구_법정동별 외지인(내국인) 소비 금액 데이터_202212.csv"));

        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202201.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202202.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202203.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202204.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202205.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202206.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202207.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202208.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202209.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202210.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202211.csv"));
        client.DBUpdateRequest(new File("src/main/resources/대전광역시 유성구_법정동별 일평균 유동인구 데이터_20221231/법정동별 일평균 유동인구 데이터_202212.csv"));

        while(true) {}
    }
}
