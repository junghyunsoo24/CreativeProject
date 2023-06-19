package frontend.Boundary;

import frontend.Boundary.Foreigner.DongAnalysis;
import frontend.Boundary.Foreigner.LargeCategoryAnalysis;
import frontend.Boundary.Foreigner.MonthAnalysis;
import frontend.Boundary.Foreigner.TotalAnalysis;
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

public class ForeignerStatisticsPageController {
    @FXML
    private Button backBtn;
    @FXML
    private Button outsiderStatisticsBtn;

    @FXML
    private Button totalChartbtn;
    @FXML
    private Button dongChartbtn;
    @FXML
    private Button largeCategoryChartbtn;
    @FXML
    private Button monthChartshow4btn;

    private Town town;
    private Village village;
    private Sectors sectors;

    public void initialize() {

    }
    @FXML
    private void moveToOutsiderStatisticsPage()throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/OutsiderStatisticsPage.fxml"));
        Parent otherPage = loader.load();

        OutsiderStatisticsPageController controller = loader.getController();
        controller.initData(town,village,sectors);

        Scene currentScene = outsiderStatisticsBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Analysis Page");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        //mainPageController.initialize();
        System.out.println(town +"ㅁㄴㅇ"+ village + "ㅁㄴㅇ" + sectors);
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
    private void handleShowChart(ActionEvent event) throws Exception {
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getId().equals("totalChartbtn")) {
            Stage primaryStage = (Stage) clickedButton.getScene().getWindow();
            TotalAnalysis totalAnalysis = new TotalAnalysis(town, village, sectors);
            totalAnalysis.start(primaryStage);
        } else if (clickedButton.getId().equals("dongChartbtn")) {
            Stage primaryStage = (Stage) clickedButton.getScene().getWindow();
            DongAnalysis dongAnalysis = new DongAnalysis(town, village, sectors);
            dongAnalysis.start(primaryStage);
        } else if (clickedButton.getId().equals("largeCategoryChartbtn")) {
            Stage primaryStage = (Stage) clickedButton.getScene().getWindow();
            LargeCategoryAnalysis largeCategoryAnalysis = new LargeCategoryAnalysis(town, village, sectors);
            largeCategoryAnalysis.start(primaryStage);
        } else if (clickedButton.getId().equals("monthChartshow4btn")) {
            Stage primaryStage = (Stage) clickedButton.getScene().getWindow();
            MonthAnalysis monthAnalysis = new MonthAnalysis(town, village, sectors);
            monthAnalysis.start(primaryStage);
        }
    }

    public void initData(Town town, Village village, Sectors sectors) {
        this.town = town;
        this.village = village;
        this.sectors = sectors;
    }
}
