package frontend.Boundary.All;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class DongAnalysis extends Application {

    @Override
    public void start(Stage primaryStage) {
        // X축 생성
        NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("X");

        // Y축 생성
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Y");

        // LineChart 생성
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("꺾은선 그래프 예시");

        // 데이터 추가
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("데이터");
        series.getData().add(new XYChart.Data<>(1, 1));
        series.getData().add(new XYChart.Data<>(2, 2));

        // 데이터셋을 그래프에 추가
        lineChart.getData().add(series);

        // Scene 생성
        Scene scene = new Scene(lineChart, 600, 400);

        // Stage 설정
        primaryStage.setTitle("꺾은선 그래프 예시");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}