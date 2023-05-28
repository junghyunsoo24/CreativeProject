package Boundary;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController
{

    @FXML
    private TextField input_id;
    @FXML
    private TextField input_pwd;
    @FXML
    private Button backBtn;
    @FXML
    private Button loginBtn;

    public void initialize() {

    }

    @FXML
    private void handleloginBtn() throws IOException
    {
        String id = input_id.getText();
        String pwd = input_pwd.getText();
        Boolean loginSuccess = false;
        //로그인 Control
        if(loginSuccess)
        {
            moveToDBUpdatePage();
        }

    }
    private void moveToDBUpdatePage()throws IOException
    {
        Parent otherPage = FXMLLoader.load(getClass().getResource("DBupdatePage.fxml"));
        //MainPageController mainPageController = FXMLLoader.getController();

        Scene currentScene = loginBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("DBupdate Page");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //mainPageController.initialize();
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
