package Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.JFrame;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.*;

public class LargeCategoryDataAnalysis extends JFrame {
    //대분류와 이용금액을 저장
    TreeMap<String, Double> dongAmountMap = new TreeMap<>();

    //이용금액 출력 포맷
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    // 그래프 그리기 위한 데이터셋 생성
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    private String largeCategory = ""; // 대분류명
    private double amount = 0.0; // 이용금액

    public LargeCategoryDataAnalysis() {
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
                largeCategory = values[5]; // 대분류명

                if(check.equals("A")||check.equals("D")||check.equals("M")||check.equals("N")||check.equals("O")||check.equals("R")||check.equals("S")){
                    amount = Double.parseDouble(values[7]);
                }
                else if(check.equals("E")) {
                    amount = Double.parseDouble(values[8]);
                }
                else {
                    amount = Double.parseDouble(values[6]);
                }

                // 대분류명이 이미 HashMap에 저장되어 있는 경우, 이용금액을 누적하여 합산
                if (dongAmountMap.containsKey(largeCategory)) {
                    double currentAmount = dongAmountMap.get(largeCategory);
                    dongAmountMap.put(largeCategory, currentAmount + amount);
                } else {
                    // 대분류명이 처음 나온 경우, 새로운 항목으로 추가
                    dongAmountMap.put(largeCategory, amount);
                }

            }

            // TreeMap의 엔트리를 순회하며 데이터셋에 값을 추가
            for (Map.Entry<String, Double> entry : dongAmountMap.entrySet()) {
                String largeCategory = entry.getKey();
                double amount = entry.getValue();

                // 데이터셋에 값 추가
                dataset.setValue(amount, "2020년 대분류별 이용 금액", largeCategory);
            }

            // 엔트리를 List에 저장
            List<Map.Entry<String, Double>> entryList = new ArrayList<>(dongAmountMap.entrySet());

            // 엔트리를 금액을 기준으로 내림차순 정렬
            Collections.sort(entryList, (entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));


            // 최댓값 출력
            Map.Entry<String, Double> maxEntry = entryList.get(0);
            String maxLargeCategory = maxEntry.getKey();
            double maxAmount = maxEntry.getValue();
            String formattedMaxAmount = decimalFormat.format(maxAmount);
            System.out.println("가장 많이 소비한 대분류는 " + maxLargeCategory + "에 " + formattedMaxAmount + "원 입니다.");

            // 최솟값 출력
            Map.Entry<String, Double> minEntry = entryList.get(entryList.size() - 1);
            String minLargeCategory = minEntry.getKey();
            double minAmount = minEntry.getValue();
            String formattedMinAmount = decimalFormat.format(minAmount);
            System.out.println("가장 적게 소비한 대분류는 " + minLargeCategory + "에 " + formattedMinAmount + "원 입니다.");

            // 차트 생성
            JFreeChart chart = ChartFactory.createBarChart(
                    "2020년 대분류별 이용 금액", // 차트 제목
                    "대분류명", // X축 레이블
                    "이용 금액", // Y축 레이블
                    dataset // 데이터셋
            );

            // X축 데이터의 라벨을 대분류명으로 설정
            chart.getCategoryPlot().getDomainAxis().setLabelFont(new Font("맑은 고딕", Font.BOLD, 12));

            // Y축 데이터의 라벨을 이용금액으로 설정
            chart.getCategoryPlot().getRangeAxis().setLabelFont(new Font("맑은 고딕", Font.BOLD, 12));

            // Y축 데이터의 레이블 포맷 설정
            NumberAxis rangeAxis = (NumberAxis) chart.getCategoryPlot().getRangeAxis();
            rangeAxis.setNumberFormatOverride(decimalFormat);

            // ChartPanel 객체 생성 및 지정
            ChartPanel chartPanel = new ChartPanel(chart);
            add(chartPanel);
            setTitle("2020년 대분류별 이용 금액");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(500, 480);
            setLocationRelativeTo(null);
            setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LargeCategoryDataAnalysis();
    }
}
