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

public class PriceDataAnalysis extends Application {
    //법정동과 이용금액을 저장
    TreeMap<String, Double> monthAmountMap = new TreeMap<>();
    //이용금액 출력 포맷
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");
    private String maxDongName = ""; // 최대값 가지는 법정동명
    private String minDongName = ""; // 최솟값 가지는 법정동명
    private String maxLargeCategory = ""; // 최대값 가지는 대분류명
    private String minLargeCategory = ""; // 최솟값 가지는 대분류명
    private String maxMonth = ""; // 최대값 가지는 기준월
    private String minMonth = ""; // 최솟값 가지는 기준월
    private double amount = 0.0; // 이용금액
    private final XYChart.Series<String, Number> series = new XYChart.Series<>();
    private ObservableList<XYChart.Series<String, Number>> chartData;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        // 데이터셋 생성
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        chartData = barChart.getData();

        // CSV 파일 로드
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sunni\\OneDrive\\바탕 화면\\창의프로젝트\\유성구_법정동별 소비금액 데이터_2020.csv"))) {
            String line;
            boolean isFirstLine = true;

            //최댓값,최솟값 구함
            double min = 1000000000, max = 0;

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

                if (check.equals("A") || check.equals("D") || check.equals("M") || check.equals("N") || check.equals("O") || check.equals("R") || check.equals("S")) {
                    amount = Double.parseDouble(values[7]);
                } else if (check.equals("E")) {
                    amount = Double.parseDouble(values[8]);
                } else {
                    amount = Double.parseDouble(values[6]);
                }

                //최댓값 최솟값 변경
                if (min > amount) {
                    min = amount;
                    minDongName = values[3];
                    minLargeCategory = values[5];
                    minMonth = values[1];
                }
                if (max < amount) {
                    max = amount;
                    maxDongName = values[3];
                    maxLargeCategory = values[5];
                    maxMonth = values[1];
                }
            }

            //이용금액 출력포맷 변경
            String formattedMaxAmount = decimalFormat.format(max);
            String formattedMinAmount = decimalFormat.format(min);

            // 최솟값을 나타내는 바 차트 데이터 생성
            XYChart.Series<String, Number> minSeries = new XYChart.Series<>();
            minSeries.setName("최솟값");
            minSeries.getData().add(new XYChart.Data<>(minDongName, min));


            // 최댓값을 나타내는 바 차트 데이터 생성
            XYChart.Series<String, Number> maxSeries = new XYChart.Series<>();
            maxSeries.setName("최댓값");
            maxSeries.getData().add(new XYChart.Data<>(maxDongName, max));


            // 데이터셋을 차트에 추가
            chartData.addAll(minSeries, series, maxSeries);


            //result

            Label maxLabel = new Label("가장 많이 쓴 금액에 정보는: " + maxDongName + ", " + maxLargeCategory + ", " + maxMonth + "월, " + formattedMaxAmount + "원");
            Label minLabel = new Label("가장 적게 쓴 금액에 정보는: " + minDongName + ", " + minLargeCategory + ", " + minMonth + "월, " + formattedMinAmount + "원");

            // root에 컴포넌트 추가
            root.getChildren().addAll(barChart, maxLabel, minLabel);

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
}
