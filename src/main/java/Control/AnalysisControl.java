package Control;

import Entity.Analysis;
import Entity.Statistics;
import Enum.Sectors; //업종
import Enum.Town; //시
import Enum.Village; //동
import persistence.DTO.DTO;
import persistence.Protocol.ProtocolQuery;
import persistence.Protocol.ProtocolType;

import java.io.IOException;
import java.util.List;


public class AnalysisControl {

    private final Statistics myStatistics;
    // 생성자
    public AnalysisControl(Town town, Village village, Sectors sectors) {
        // 생성자 로직
        myStatistics = new Statistics(sectors, town, village);
    }
    // 법정동별 소비 추세 통계 함수
    public void analyzeConsumptionByLegalDong() {
        myStatistics.analyzeConsumptionByLegalDong();
    }
    // 대분류별 통계 함수
    public void analyzeConsumptionByIndustry() {
        myStatistics.analyzeConsumptionByIndustry();
    }


    // 연도별 소비 추세 통계 함수
    public void analyzeConsumptionByYear() {
        myStatistics.analyzeConsumptionByYear();
    }

    // 월별 소비 경향 통계 함수
    public void analyzeConsumptionByMonth() {
        myStatistics.analyzeConsumptionByMonth();
    }

    public static List<DTO> selectRequest(ProtocolQuery query, ProtocolType type) throws IOException, ClassNotFoundException {
        Analysis analysis = new Analysis();
        return analysis.select(query, type);
    }
}
