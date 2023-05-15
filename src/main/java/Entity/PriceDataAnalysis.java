package Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import java.awt.Font;
import java.text.DecimalFormat;

public class PriceDataAnalysis extends JFrame {
    private String maxDongName = ""; // 최대값 가지는 법정동명
    private String minDongName = ""; // 최솟값 가지는 법정동명

    private String maxLargeCategory = ""; // 최대값 가지는 대분류명
    private String minLargeCategory = ""; // 최솟값 가지는 대분류명

    private String maxMonth = ""; // 최대값 가지는 기준월
    private String minMonth = ""; // 최솟값 가지는 기준월

    private double amount = 0.0; // 이용금액

    //이용금액 출력 포맷
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    public PriceDataAnalysis() {
        // JFrame에 ChartPanel 추가
        Font font = new Font("맑은 고딕", Font.BOLD, 5);
        StandardChartTheme theme = new StandardChartTheme("Korean");
        theme.setExtraLargeFont(font);
        theme.setLargeFont(font);
        theme.setRegularFont(font);
        theme.setSmallFont(font);
        ChartFactory.setChartTheme(theme);

        // CSV 파일 로드
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sunni\\OneDrive\\바탕 화면\\창의프로젝트\\유성구_법정동별 소비금액 데이터_2020.csv"))) {
            String line;
            boolean isFirstLine = true;

            //최댓값,최솟값 구함
            double min = 1000000000, max = 0;

            // 데이터셋 생성
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            //null 행 나올때까지 파일 읽기
            while ((line = reader.readLine()) != null) {
                //첫번째 행은 무시
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                //한국표준산업분류에 ,때문에 케이스를 나눔
                //ex 농업,임업및 어업
                //ex 광업
                String[] values = line.split(",");
                String check = values[4];

                if(check.equals("A")||check.equals("D")||check.equals("M")||check.equals("N")||check.equals("O")||check.equals("R")||check.equals("S")){
                    amount = Double.parseDouble(values[7]);
                }
                else if(check.equals("E")) {
                    amount = Double.parseDouble(values[8]);
                }
                else {
                    amount = Double.parseDouble(values[6]);
                }

                //최댓값 최솟값 변경
                if(min > amount) {
                    min = amount;
                    minDongName = values[3];
                    minLargeCategory = values[5];
                    minMonth = values[1];
                }
                if(max < amount) {
                    max = amount;
                    maxDongName = values[3];
                    maxLargeCategory = values[5];
                    maxMonth = values[1];
                }
            }

            //이용금액 출력포맷 변경
            String formattedMaxAmount = decimalFormat.format(max);
            String formattedMinAmount = decimalFormat.format(min);

            //result
            System.out.println(String.format("가장 많이 쓴 금액에 정보는: %s / %s / %s월 / %s원", maxDongName, maxLargeCategory, maxMonth, formattedMaxAmount));
            System.out.println(String.format("가장 적게 쓴 금액에 정보는: %s / %s / %s월 / %s원", minDongName, minLargeCategory, minMonth, formattedMinAmount));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new PriceDataAnalysis();
    }
}