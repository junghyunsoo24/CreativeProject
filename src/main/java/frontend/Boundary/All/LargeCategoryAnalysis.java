package frontend.Boundary.All;

import frontend.Boundary.AllAnalysisController;
import frontend.Boundary.AllStatisticsPageController;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import backend.DB.DTO.ConsumptionAmountDTO;
import backend.DB.DTO.DTO;
import backend.DB.Protocol.ProtocolQuery;
import backend.DB.Protocol.ProtocolType;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class LargeCategoryAnalysis extends Application {
    //법정동과 이용금액을 저장
    TreeMap<String, Double> divisionAmountMap = new TreeMap<>();

    //이용금액 출력 포맷
    DecimalFormat decimalFormat = new DecimalFormat("#,##0");

    private XYChart.Series<String, Number> series = new XYChart.Series<>();
    private ObservableList<XYChart.Series<String, Number>> chartData;

    private Town town;
    private Village village;
    private Sectors sectors;

    // 데이터셋을 차트에 추가

    public LargeCategoryAnalysis(Town town, Village village, Sectors sectors) {
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
                loader.setLocation(getClass().getClassLoader().getResource("view/AllAnalysisPage.fxml"));
                Parent statisticsPage = loader.load();
                AllAnalysisController controller = loader.getController();
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


        // DB에서 표준산업대분류별 소비금액 데이터 추출
        List<DTO> dtoList = AnalysisControl.selectRequest(ProtocolQuery.selectAll, ProtocolType.CA);
        for (DTO dto : dtoList) {
            //대분류명
            String division = ((ConsumptionAmountDTO) dto).getIndustry_name();
            // 이용금액
            double amount = ((ConsumptionAmountDTO) dto).getAmount();

            // 대분류명이 이미 HashMap에 저장되어 있는 경우, 이용금액을 누적하여 합산
            double currentAmount = divisionAmountMap.containsKey(division) ? divisionAmountMap.get(division) : 0;
            divisionAmountMap.put(division, currentAmount + amount);
        }


        // 엔트리를 List에 저장
        List<Map.Entry<String, Double>> entryList = new ArrayList<>(divisionAmountMap.entrySet());

        // 엔트리를 금액을 기준으로 내림차순 정렬
        entryList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));
        Long sum = ClientApp.getDB().selectRequest(ProtocolQuery.selectSum, ProtocolType.CA, sectors.getCode());
        String formattedMaxSum = decimalFormat.format(sum);

        Label divisionCheckSum = new Label("선택한 대분류는 " + sectors + " 에 "  +formattedMaxSum+ "원입니다." );
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

        Long sums = ClientApp.getDB().selectRequest(ProtocolQuery.selectSum, ProtocolType.CA, village.getName());
        double bigNum = maxAmount - sum;
        double smallNum = minAmount - sum;
        if(bigNum > sum){
            ClientApp.text = sectors.getIndustry() + " 분석결과 대분류에서\n 사용하는 비용이 최댓값과 가까이 있어서\n 고려해볼만하다!";
        }
        else{
            ClientApp.text = sectors.getIndustry() + " 분석결과 대분류에서\n 사용하는 비용이 최솟값과 가까이 있어서\n 적절하지 않을 거라 생각된다.";
        }

        // 데이터 생성
        series.getData().add(new XYChart.Data<>(maxDivision, maxAmount));
        series.getData().add(new XYChart.Data<>(minDivision, minAmount));
        series.getData().add(new XYChart.Data<>(sectors.getCode(), sums));

        // 그래프 생성 및 데이터 설정
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.getData().add(series);

        // root에 컴포넌트 추가
        root.getChildren().addAll(barChart,divisionCheckSum, maxLabel,minLabel);
        root.getChildren().add(backButton); // 다음 버튼 추가

        // Scene 생성
        Scene scene = new Scene(root, 600, 400);

        // Stage 설정
        primaryStage.setTitle("모든인원 대분류별 분석");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
