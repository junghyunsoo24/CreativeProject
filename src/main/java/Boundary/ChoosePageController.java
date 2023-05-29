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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/ResultPage.fxml"));
        Parent otherPage = loader.load();

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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/StatisticsPage.fxml"));
        Parent otherPage = loader.load();
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
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/MainPage.fxml"));
        Parent otherPage = loader.load();
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
