package Boundary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DBUpdateController
{
    @FXML
    private Button backBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField input_filePath;

    public void initialize() {

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
    @FXML
    private void handleUpdateBtn() throws IOException
    {


        //파일 업데이트 호출
    }
}
