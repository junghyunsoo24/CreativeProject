package Entity;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class LargeCategoryDataAnalysis extends Application {
    //법정동과 이용금액을 저장
    TreeMap<String, Double> divisionAmountMap = new TreeMap<>();

    //이용금액 출력 포맷
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    private String division = "" ; //대분류명
    private double amount = 0.0; // 이용금액

    private XYChart.Series<String, Number> series = new XYChart.Series<>();
    private ObservableList<XYChart.Series<String, Number>> chartData;
    private String checkDivision = "";

    public LargeCategoryDataAnalysis(String division) {
        checkDivision = division;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // "다음" 버튼 생성
        Button nextButton = new Button("다음");
        nextButton.setOnAction(event -> {
            // 다른 클래스를 여기에 호출하고 원하는 동작을 수행
            MonthDataAnalysis anotherClass = new MonthDataAnalysis();
            try {
                anotherClass.start(primaryStage);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        VBox root = new VBox();

        // 데이터셋 생성
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        chartData = barChart.getData();

        // CSV 파일 로드
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/유성구_법정동별 소비금액 데이터_2020.csv"))) {
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
                division = values[5]; // 대분류명

                if (check.equals("A") || check.equals("D") || check.equals("M") || check.equals("N") || check.equals("O") || check.equals("R") || check.equals("S")) {
                    amount = Double.parseDouble(values[7]);
                } else if (check.equals("E")) {
                    amount = Double.parseDouble(values[8]);
                } else {
                    amount = Double.parseDouble(values[6]);
                }

                // 대분류명이 이미 HashMap에 저장되어 있는 경우, 이용금액을 누적하여 합산
                if (divisionAmountMap.containsKey(division)) {
                    double currentAmount = divisionAmountMap.get(division);
                    divisionAmountMap.put(division, currentAmount + amount);
                } else {
                    // 대분류명이 처음 나온 경우, 새로운 항목으로 추가
                    divisionAmountMap.put(division, amount);
                }
            }

            // TreeMap의 엔트리를 순회하며 데이터셋에 값을 추가
            for (Map.Entry<String, Double> entry : divisionAmountMap.entrySet()) {
                String division = entry.getKey();
                double amount = entry.getValue();

                // 데이터셋에 값 추가
                series.getData().add(new XYChart.Data<>(division, amount));
            }

            // 데이터셋을 차트에 추가
            chartData.add(series);

            // 엔트리를 List에 저장
            List<Map.Entry<String, Double>> entryList = new ArrayList<>(divisionAmountMap.entrySet());

            // 엔트리를 금액을 기준으로 내림차순 정렬
            entryList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));

            // 대분류 데이터분석
            int count = 1;
            for (Map.Entry<String, Double> entry : entryList) {
                String division = entry.getKey();
                if(division.equals(checkDivision))
                    break;
                System.out.println(division);
                System.out.println(checkDivision);
                count++;
            }
            Label dvisionCheckLabel = new Label("선택한 대분류는 " + checkDivision + "이고 21번째 중에서 " + count + "째로 많이 소비합니다.");

            // 최댓값 출력
            Map.Entry<String, Double> maxEntry = entryList.get(0);
            String maxDivision = maxEntry.getKey();
            double maxAmount = maxEntry.getValue();
            String formattedMaxAmount = decimalFormat.format(maxAmount);
            Label maxLabel = new Label("가장 많이 소비한 대분류는 " + maxDivision + "에 " + formattedMaxAmount + "원 입니다.");

            // 최솟값 출력
            Map.Entry<String, Double> minEntry = entryList.get(entryList.size() - 1);
            String minDivision = minEntry.getKey();
            double minAmount = minEntry.getValue();
            String formattedMinAmount = decimalFormat.format(minAmount);
            Label minLabel = new Label("가장 적게 소비한 대분류는 " + minDivision + "에 " + formattedMinAmount + "원 입니다.");

            // root에 컴포넌트 추가
            root.getChildren().addAll(barChart, dvisionCheckLabel, maxLabel, minLabel, nextButton);

            // Scene 생성
            Scene scene = new Scene(root, 800, 600);

            // Stage 설정
            primaryStage.setTitle("2020년 법정동별 이용 금액");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
