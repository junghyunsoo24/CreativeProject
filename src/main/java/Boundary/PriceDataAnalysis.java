package Boundary;

import Control.AnalysisControl;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.Main;
import persistence.DTO.ConsumptionAmountDTO;
import persistence.DTO.DTO;
import persistence.Protocol.ProtocolQuery;
import persistence.Protocol.ProtocolType;

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

        double max = 0;
        double min = Integer.MAX_VALUE;

        List<DTO> dtoList = AnalysisControl.selectRequest(ProtocolQuery.selectAll, ProtocolType.CA);
        for (DTO dto : dtoList) {
            // 이용금액
            double amount = ((ConsumptionAmountDTO) dto).getAmount();

            //최댓값 최솟값 변경
            if (min > amount) {
                min = amount;
                minDongName = ((ConsumptionAmountDTO) dto).getDong_name();
                minLargeCategory = ((ConsumptionAmountDTO) dto).getIndustry_name();
                minMonth = String.valueOf(((ConsumptionAmountDTO) dto).getMonth());
            }
            if (max < amount) {
                max = amount;
                maxDongName = ((ConsumptionAmountDTO) dto).getDong_name();
                maxLargeCategory = ((ConsumptionAmountDTO) dto).getIndustry_name();
                maxMonth = String.valueOf(((ConsumptionAmountDTO) dto).getMonth());
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
        Label maxLabel = new Label("가장 많이 쓴 금액의 정보는: " + maxDongName + ", " + maxLargeCategory + ", " + maxMonth + "월, " + formattedMaxAmount + "원");
        Label minLabel = new Label("가장 적게 쓴 금액의 정보는: " + minDongName + ", " + minLargeCategory + ", " + minMonth + "월, " + formattedMinAmount + "원");

        // root에 컴포넌트 추가
        root.getChildren().addAll(barChart, maxLabel, minLabel);

        // Scene 생성
        Scene scene = new Scene(root, 800, 600);

        // Stage 설정
        primaryStage.setTitle("법정동별 이용 금액");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
