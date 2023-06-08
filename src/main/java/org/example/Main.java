package org.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.DBClient;

public class Main extends Application {

    private static Stage primaryStageObj;
    private static DBClient db;

    public static DBClient getDB() {
        return db;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        db = new DBClient("localhost", 3000);
        primaryStageObj = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("view/MainPage.fxml"));
        Parent root = loader.load();

        Scene mainScene = new Scene(root, 600,400);
        primaryStage.setResizable(false);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getPrimaryStage() {
        return primaryStageObj;
    }
}
