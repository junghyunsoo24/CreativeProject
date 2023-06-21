package frontend;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import backend.DB.DBConnector;

public class ClientApp extends Application {

    private static Stage primaryStageObj;
    private static DBConnector db;

    public static String text; //대분류
    public static String text2; //동

    public static DBConnector getDB() {
        return db;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        db = new DBConnector("119.56.139.127", 3000);
//        db = new DBConnector("localhost", 3000);
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
