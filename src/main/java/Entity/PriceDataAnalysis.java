package Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class
PriceDataAnalysis extends Application {
    @Override
    public void start(Stage stage) {
        // CSV 파일 로드
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\sunni\\OneDrive\\바탕 화면\\창의프로젝트\\유성구_법정동별 소비금액 데이터_2020.csv"))) {
            String line;
            boolean isFirstLine = true;

            // 최댓값, 최솟값 구함
            double min = 100000, max = 0;

            // 데이터셋 생성
            XYChart.Series<String, Number> series = new XYChart.Series<>();

            // null 행 나올 때까지 파일 읽기
            while ((line = reader.readLine()) != null) {
                // 첫 번째 행은 무시
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] valuesCheck = line.split(",");
                String check = valuesCheck[4];
                double value;
                if (check.equals("A") || check.equals("D") || check.equals("M") || check.equals("N") || check.equals("O") || check.equals("R") || check.equals("S")) {
                    value = Double.parseDouble(valuesCheck[7]);
                } else if (check.equals("E")) {
                    value = Double.parseDouble(valuesCheck[8]);
                } else {
                    value = Double.parseDouble(valuesCheck[6]);
                }

                String label = valuesCheck[3];
                if (min > value)
                    min = value;
                if (max < value)
                    max = value;

                series.getData().add(new XYChart.Data<>(label, value));
            }

            // 결과 출력
            System.out.println("가장 많이 쓴 금액은: " + max + "원");
            System.out.println("가장 적게 쓴 금액은 " + min + "원");

            // X축과 Y축 생성
            CategoryAxis xAxis = new CategoryAxis();
            NumberAxis yAxis = new NumberAxis();

            // BarChart 생성
            BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
            barChart.getData().add(series);

            // 창 크기 및 타이틀 설정
            stage.setTitle("CSV Graph Example");
            stage.setWidth(500);
            stage.setHeight(480);

            // 창에 BarChart 추가
            Scene scene = new Scene(barChart);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
