package Boundary;

import Control.DBControl;
import com.opencsv.exceptions.CsvException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import persistence.InvalidNameFormatException;

import java.io.File;
import java.io.IOException;


public class DBUpdateController
{
    @FXML
    private Button backBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField input_filePath;

    private String filepath;
    public void initialize() {

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
    private void handleUpdateBtn() throws IOException, CsvException, InvalidNameFormatException {
        filepath = input_filePath.getText();
        File input_file = new File(filepath);
        //파일 업데이트 호출
        DBControl db = new DBControl();
        db.DBUpdateRequest(input_file);
    }
}
