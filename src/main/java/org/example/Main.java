package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStageObj;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStageObj = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/MainPage.fxml"));
        Parent root = loader.load();

        Scene mainScene = new Scene(root);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStageObj;
    }
}
