package frontend.Boundary;

import frontend.Boundary.All.DongAnalysis;
import frontend.Enum.Sectors;
import frontend.Enum.Town;
import frontend.Enum.Village;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class OutsiderStatisticsPageController
{
//    public Chart chart;

    @FXML
    private Button backBtn;
    @FXML
    private Button analysisBtn;

    @FXML
    private Button show1btn;
    @FXML
    private Button show2btn;
    @FXML
    private Button show3btn;
    @FXML
    private Button show4btn;


    private Town town;
    private Village village;
    private Sectors sectors;



    public void initialize() {

    }
    @FXML
    private void moveToAnalysisPage() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/AllAnalysisPage.fxml"));
        Parent otherPage = loader.load();

        AllAnalysisController controller = loader.getController();
        controller.initData(town,village,sectors);

        Scene currentScene = analysisBtn.getScene();

        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Analysis Page");

//        //버튼을 누르면 내 그래프가 나오도록 코드 수정하고 싶음
//        DongAnalysis dongAnalysis = new DongAnalysis(town, village, sectors);
//        dongAnalysis.start(primaryStage);



    }

    @FXML
    private void handleBackBtn() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/MainPage.fxml"));
        Parent otherPage = loader.load();
        //MainPageController mainPageController = FXMLLoader.getController();

        Scene currentScene = backBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Main Page");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        //mainPageController.initialize();
    }

    @FXML
    private void handleShowChart(ActionEvent event) {
        System.out.println("haha");
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getId().equals("show1btn")) {
            try {
                Stage primaryStage = (Stage) clickedButton.getScene().getWindow();
                DongAnalysis dongAnalysis = new DongAnalysis(town, village, sectors);
                dongAnalysis.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (clickedButton.getId().equals("show2btn")) {
            // 두 번째 chart 호출
        } else if (clickedButton.getId().equals("show3btn")) {
            // 세 번째 chart 호출
        } else if (clickedButton.getId().equals("show4btn")) {
            // 네 번째 chart 호출
        }
    }

    public void initData(Town town, Village village, Sectors sectors) {
        this.town = town;
        this.village = village;
        this.sectors = sectors;
    }
}
