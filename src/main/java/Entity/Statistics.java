package Entity;

import Enum.Sectors; //업종
import Enum.Town; //시
import Enum.Village; //동
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import persistence.DAO.*;
import persistence.DTO.ConsumptionAmountDTO;
import persistence.DTO.DTO;
import persistence.MyBatisConnectionFactory;

import java.util.List;

public class Statistics
{
    private final Sectors sectors;
    private final Town town;
    private final  Village village;
    DAO dao;

    DefaultCategoryDataset dataset;

    public Statistics(Sectors sectors, Town town, Village village)
    {
        this.sectors = sectors;
        this.town = town;
        this.village = village;
        dao = new ConsumptionAmountDAO(MyBatisConnectionFactory.getSqlSessionFactory());
    }

    //동별 소비금액
    public void analyzeConsumptionByLegalDong()
    {
        List<ConsumptionAmountDTO> list;
        list = dao.selectAll();
        //x 동이름, y 모든 업종 총 이용금액
        StringAndAmount[] sNa = new StringAndAmount[60]; //60은 임시값.
        int i = 0;
        boolean isUpdate = false;

        for(ConsumptionAmountDTO dto: list)
        {
            for(int j =0; j < sNa.length;j++)
            {
                    if(i==0){
                        sNa[i] = new StringAndAmount(dto.getDong_name(), dto.getAmount());
                        isUpdate = true;
                        break;
                    }
                    if(sNa[i].getName() == dto.getDong_name())
                    {
                        sNa[i].addAmount(dto.getAmount());
                        isUpdate = true;
                        break;
                    }
            }
            if(!isUpdate)
            {
                i++;
                sNa[i] = new StringAndAmount(dto.getDong_name(), dto.getAmount());
            }
            isUpdate = false;
        }

        dataset = new DefaultCategoryDataset();
        //데이터 입력  값(y값), 범례(그래프 구분자?), 카테고리(x축값)
        for (StringAndAmount temp : sNa) {
            dataset.addValue(temp.getAmount(), "법정동 소비추세 통계", temp.getName());
        }

        generateChart(dataset, "법정동별 소비 추세 통계", "법정동","소비 금액");
    }

    // 대분류별 통계 함수
    public void analyzeConsumptionByIndustry()
    {
        List<ConsumptionAmountDTO> list;
        list = dao.selectAll();

        //list에는 모든 정보가 있다. sectors를 기준으로 거른다.

        StringAndAmount[] sNa = new StringAndAmount[20]; //20은 임시값.
        int i = 0;
        boolean isUpdate = false;

        for(ConsumptionAmountDTO dto: list)
        {
            for(int j =0; j < sNa.length;j++)
            {
                if(i==0){
                    sNa[i] = new StringAndAmount(dto.getIndustry_name(), dto.getAmount());
                    isUpdate = true;
                    break;
                }
                if(sNa[i].getName() == dto.getIndustry_name())
                {
                    sNa[i].addAmount(dto.getAmount());
                    isUpdate = true;
                    break;
                }
            }
            if(!isUpdate)
            {
                i++;
                sNa[i] = new StringAndAmount(dto.getIndustry_name(), dto.getAmount());
            }
            isUpdate = false;
        }

        dataset = new DefaultCategoryDataset();

        //데이터 입력  값(y값), 범례(그래프 구분자?), 카테고리(x축값)
        for (StringAndAmount temp : sNa) {
            dataset.addValue(temp.getAmount(), "업종 대 분류별 통계", temp.getName());
        }

        //list에는 모든 정보가 있다. village를 기준으로 거른다.
        generateChart(dataset, "업종 대 분류별 통계", "업종","소비 금액");
    }


    // 연도별 소비 추세 통계 함수, 선택한 동의 이용금액이 나와야 한다.
    public void analyzeConsumptionByYear()
    {
        List<ConsumptionAmountDTO> list;
        list = dao.selectAll();

        //list에는 모든 정보가 있다. 년마다 합치는 걸로 만들어야 한다.

        StringAndAmount[] sNa = new StringAndAmount[3]; //20은 임시값.
        int i = 0;
        boolean isUpdate = false;

        for(ConsumptionAmountDTO dto: list)
        {
            if(dto.getDong_name() == village.getName()) {
                for (int j = 0; j < sNa.length; j++) {
                    if (i == 0) {
                        sNa[i] = new StringAndAmount(Integer.toString(dto.getYear()), dto.getAmount());
                        isUpdate = true;
                        break;
                    }
                    if (sNa[i].getName() == Integer.toString(dto.getYear())) {
                        sNa[i].addAmount(dto.getAmount());
                        isUpdate = true;
                        break;
                    }
                }
                if (!isUpdate) {
                    i++;
                    sNa[i] = new StringAndAmount(Integer.toString(dto.getYear()), dto.getAmount());
                }
                isUpdate = false;
            }
        }
        dataset = new DefaultCategoryDataset();

        String title = "연도별" + village.getName() + "소비 추세 통계";
        //데이터 입력  값(y값), 범례(그래프 구분자?), 카테고리(x축값)
        for (StringAndAmount temp : sNa) {
            dataset.addValue(temp.getAmount(), title, temp.getName());
        }
        generateChart(dataset, title, "연도","소비 금액" );
    }

    // 월별 소비 경향 통계 함수
    public void analyzeConsumptionByMonth()
    {
        List<ConsumptionAmountDTO> list;
        list = dao.selectAll();
        //list에는 모든 정보가 있다.산업과, 법정동이 일치해야 한다.

        StringAndAmount[] sNa = new StringAndAmount[20]; //20은 임시값.
        int i = 0;
        boolean isUpdate = false;

        for(ConsumptionAmountDTO dto: list)
        {
            if((dto.getDong_name() == village.getName()) && (dto.getIndustry_name() == sectors.name())){

                for (int j = 0; j < sNa.length; j++) {
                    if (i == 0) {
                        sNa[i] = new StringAndAmount(Integer.toString(dto.getMonth()), dto.getAmount());
                        isUpdate = true;
                        break;
                    }
                    if (sNa[i].getName() == Integer.toString(dto.getMonth())) {
                        sNa[i].addAmount(dto.getAmount());
                        isUpdate = true;
                        break;
                    }
                }
                if (!isUpdate) {
                    i++;
                    sNa[i] = new StringAndAmount(Integer.toString(dto.getYear()), dto.getAmount());
                }
                isUpdate = false;
            }
        }

        StringAndAmount seasonDataset[] = new StringAndAmount[4];
        int[] season = new int[4];
        String[] season_name = {"봄", "여름", "가을", "겨울"};
        for(StringAndAmount temp : sNa)
        {

            if((temp.getName() == "1") || (temp.getName() == "2") || (temp.getName() == "3") )
            {
                season[0] += temp.getAmount();
            }
            else if((temp.getName() == "4") || (temp.getName() == "5") || (temp.getName() == "6") )
            {
                season[1] += temp.getAmount();
            }
            else if((temp.getName() == "7") || (temp.getName() == "8") || (temp.getName() == "9") )
            {
                season[2] += temp.getAmount();
            }
            else if((temp.getName() == "10") || (temp.getName() == "11") || (temp.getName() == "12") )
            {
                season[3] += temp.getAmount();
            }
        }
        for(i = 0; i < season.length; i++)
        {
            seasonDataset[i] = new StringAndAmount(season_name[i], season[i]);
        }

        dataset = new DefaultCategoryDataset();

        String title = "계절별" + village.getName() + " "+ sectors.name() +"소비 추세 통계";
        //데이터 입력  값(y값), 범례(그래프 구분자?), 카테고리(x축값)
        for (StringAndAmount temp : sNa) {
            dataset.addValue(temp.getAmount(), title, temp.getName());
        }

        generateChart(dataset, title, "월","소비 금액" );
    }


    public void generateChart(DefaultCategoryDataset dataset, String title, String xLabel, String yLabel)
    {

        // Bar Chart 생성
        JFreeChart chart = ChartFactory.createBarChart(
                title,
                xLabel,
                yLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        /* 글꼴 바꾸기 코드
        CategoryPlot plot = chart.getCategoryPlot();
        plot.getDomainAxis().setTickLabelFont(new Font("굴림", Font.PLAIN, 8));
         */

        // 차트를 프레임에 표시
        ChartFrame frame = new ChartFrame(title, chart);
        frame.pack();
        frame.setVisible(true);
    }

}
