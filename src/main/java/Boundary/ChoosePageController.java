package Boundary;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoosePageController
{
    private Button analysisBtn;
    private Button statisicsBtn;

    public void initialize() {

    }

    private void handleAnalysisBtn() throws IOException
    {
        Parent otherPage = FXMLLoader.load(getClass().getResource("ResultPage.fxml"));
        //ChoosePageController choosePageController = FXMLLoader.getController();

        Scene currentScene = analysisBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Analysis Page");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //choosePageController.initialize();
    }

    private void handleStatisticsBtn() throws IOException
    {
        Parent otherPage = FXMLLoader.load(getClass().getResource("StatisticsPage.fxml"));
        //ChoosePageController choosePageController = FXMLLoader.getController();

        Scene currentScene = statisicsBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Statistics Page");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //choosePageController.initialize();
    }
}
