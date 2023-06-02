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
import persistence.DBClient;
import persistence.DTO.ConsumptionAmountDTO;
import persistence.DTO.DTO;
import persistence.ProtocolQuery;
import persistence.ProtocolType;

import java.text.DecimalFormat;
import java.util.*;

public class LargeCategoryDataAnalysis extends Application {
    //법정동과 이용금액을 저장
    TreeMap<String, Double> divisionAmountMap = new TreeMap<>();

    //이용금액 출력 포맷
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    private XYChart.Series<String, Number> series = new XYChart.Series<>();
    private ObservableList<XYChart.Series<String, Number>> chartData;
    private String selectedDivision = "";
    private final DBClient DB;
    private final int CATEGORY_COUNT;


    public LargeCategoryDataAnalysis(String division, DBClient db, int categoryCount) {
        selectedDivision = division;
        DB = db;
        CATEGORY_COUNT = categoryCount;
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

        // DB에서 표준산업대분류별 소비금액 데이터 추출
        List<DTO> dtoList = DB.selectRequest(ProtocolQuery.selectAll, ProtocolType.CA);
        for (DTO dto : dtoList) {
            //대분류명
            String division = ((ConsumptionAmountDTO) dto).getIndustry_name();
            // 이용금액
            double amount = ((ConsumptionAmountDTO) dto).getAmount();

            // 대분류명이 이미 HashMap에 저장되어 있는 경우, 이용금액을 누적하여 합산
            double currentAmount = divisionAmountMap.containsKey(division) ? divisionAmountMap.get(division) : 0;
            divisionAmountMap.put(division, currentAmount + amount);
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

        // 동 데이터분석
        int count = 0;
        for (String currentDivision = entryList.get(count).getKey(); count < entryList.size() && !currentDivision.contains(selectedDivision); currentDivision = entryList.get(++count).getKey()) {
            //pass
        }
        Label divisionCheckLabel = new Label("선택한 대분류는 " + selectedDivision + "이고 " + CATEGORY_COUNT + "번째 중에서 " + (count + 1) + "째로 많이 소비합니다.");

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
        root.getChildren().addAll(barChart, divisionCheckLabel, maxLabel, minLabel, nextButton);

        // Scene 생성
        Scene scene = new Scene(root, 800, 600);

        // Stage 설정
        primaryStage.setTitle("2020년 법정동별 이용 금액");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
