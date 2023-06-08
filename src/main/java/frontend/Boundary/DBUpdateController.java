package frontend.Boundary;

import frontend.Control.DBUpdateControl;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class DBUpdateController
{
    @FXML
    private Button backBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private Button uploadBtn;
    @FXML
    private Text fileName;
    private Stage primaryStage;
    private File file;

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
    private void handleUpdateBtn() throws IOException {
        DBUpdateControl.DBUpdate(file);
    }

    @FXML
    private void handleUploadBtn() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("csv 파일", "*.csv"));
        file = fc.showOpenDialog(primaryStage);

        if (file != null) {
            fileName.setText(file.getName());
        }
    }
}
