package frontend.Boundary.Foreigner;


import backend.DB.DTO.ConsumptionAmountForeignerDTO;
import frontend.Boundary.ForeignerStatisticsPageController;
import frontend.ClientApp;
import frontend.Control.AnalysisControl;
import frontend.Enum.Sectors;
import frontend.Enum.Town;
import frontend.Enum.Village;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import backend.DB.DTO.DTO;
import backend.DB.Protocol.ProtocolQuery;
import backend.DB.Protocol.ProtocolType;

import java.text.DecimalFormat;
import java.util.*;

public class DongStats extends Application {
    //법정동과 이용금액을 저장
    TreeMap<String, Double> dongAmountMap = new TreeMap<>();

    //이용금액 출력 포맷
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    private XYChart.Series<String, Number> series = new XYChart.Series<>();
    private ObservableList<XYChart.Series<String, Number>> chartData;

    private Town town;
    private Village village;
    private Sectors sectors;

    public DongStats(Town town, Village village, Sectors sectors) {
        this.town = town;
        this.village = village;
        this.sectors = sectors;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();

        // "이전" 버튼 생성
        Button backButton = new Button("되돌아가기");
        backButton.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getClassLoader().getResource("view/ForeignerStatisticsPage.fxml"));
                Parent statisticsPage = loader.load();
                ForeignerStatisticsPageController controller = loader.getController();
                controller.initData(town, village, sectors);
                Scene currentScene = backButton.getScene();
                currentScene.setRoot(statisticsPage);
                Stage prmaryStage = (Stage) currentScene.getWindow();
                prmaryStage.setTitle("Statistics Page");
                prmaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 데이터셋 생성
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        chartData = barChart.getData();

        // DB에서 법정동별 소비금액 데이터 추출
        List<DTO> dtoList = AnalysisControl.selectRequest(ProtocolQuery.selectAll, ProtocolType.CAF);
        for (DTO dto : dtoList) {
            // 법정동명
            String dongName = ((ConsumptionAmountForeignerDTO) dto).getDong_name();
            // 이용금액
            double amount = ((ConsumptionAmountForeignerDTO) dto).getAmount();

            // 법정동명이 이미 TreeMap에 저장되어 있는 경우, 이용금액을 누적하여 합산
            double currentAmount = dongAmountMap.containsKey(dongName) ? dongAmountMap.get(dongName) : 0;
            dongAmountMap.put(dongName, currentAmount + amount);
        }

        // TreeMap의 엔트리를 순회하며 데이터셋에 값을 추가
        for (Map.Entry<String, Double> entry : dongAmountMap.entrySet()) {
            String dongName = entry.getKey();
            double amount = entry.getValue();

            // 데이터셋에 값 추가
            series.getData().add(new XYChart.Data<>(dongName, amount));
        }

        // 데이터셋을 차트에 추가
        chartData.add(series);

        // 엔트리를 List에 저장
        List<Map.Entry<String, Double>> entryList = new ArrayList<>(dongAmountMap.entrySet());

        // 엔트리를 금액을 기준으로 내림차순 정렬
        entryList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));

        Long sum = ClientApp.getDB().selectRequest(ProtocolQuery.selectSum, ProtocolType.CAF, village.getName());
        String formattedSum = decimalFormat.format(sum);
        Label DongCheckLabel = new Label("선택한 동은 " + village + "에 "  + formattedSum + "원 입니다.");

        // 최댓값 출력
        Map.Entry<String, Double> maxEntry = entryList.get(0);
        String maxDongName = maxEntry.getKey();
        double maxAmount = maxEntry.getValue();
        String formattedMaxAmount = decimalFormat.format(maxAmount);
        Label maxLabel = new Label("가장 많이 소비한 동은 " + maxDongName + "에 " + formattedMaxAmount + "원 입니다.");

        // 최솟값 출력
        Map.Entry<String, Double> minEntry = entryList.get(entryList.size() - 1);
        String minDongName = minEntry.getKey();
        double minAmount = minEntry.getValue();
        String formattedMinAmount = decimalFormat.format(minAmount);
        Label minLabel = new Label("가장 적게 소비한 동은 " + minDongName + "에 " + formattedMinAmount + "원 입니다.");

        // root에 컴포넌트 추가
        root.getChildren().addAll(barChart, DongCheckLabel, maxLabel, minLabel);
        root.getChildren().add(backButton); // 다음 버튼 추가

        // Scene 생성
        Scene scene = new Scene(root, 600, 400);

        // Stage 설정
        primaryStage.setTitle("법정동별 이용 금액");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
