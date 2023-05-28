package Boundary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ChoosePageController
{
    @FXML
    private Button analysisBtn;
    @FXML
    private Button statisticsBtn;
    @FXML
    private Button backBtn;


    private String choosedTown;
    private String choosedVillage;
    private String choosedSectors;

    public void initialize(String choosedTown, String choosedVillage, String choosedSectors) {
        this.choosedTown = choosedTown;
        this.choosedVillage = choosedVillage;
        this.choosedSectors = choosedSectors;
    }

    @FXML
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
        //choosePageController.initialize(choosedTown,choosedVillage, choosedSectors );
    }

    @FXML
    private void handleStatisticsBtn() throws IOException
    {
        Parent otherPage = FXMLLoader.load(getClass().getResource("StatisticsPage.fxml"));
        //ChoosePageController choosePageController = FXMLLoader.getController();

        Scene currentScene = statisticsBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Statistics Page");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //choosePageController.initialize(choosedTown,choosedVillage, choosedSectors );
    }
    @FXML
    private void handleBackBtn() throws IOException
    {
        Parent otherPage = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        //MainPageController mainPageController = FXMLLoader.getController();

        Scene currentScene = backBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Main Page");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //mainPageController.initialize();
    }
}
