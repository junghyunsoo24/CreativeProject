package Boundary;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class MainPage {
    @FXML
    private Button myButton;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }
/*
    @FXML
        private void handleButtonClick() {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/"));
                Parent root = loader.load();

                Scene scene = new Scene(root);

                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 */

}
