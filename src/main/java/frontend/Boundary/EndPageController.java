package frontend.Boundary;

import frontend.Boundary.Outsider.LargeCategoryAnalysis;
import frontend.ClientApp;
import frontend.Enum.Sectors;
import frontend.Enum.Town;
import frontend.Enum.Village;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class EndPageController {
    //전체 인원에 동별/대분류별을 통해 분석하는 것이기 때문에 전체 분석 페이지에 동별 분석, 대분류별 분석을 통해 그래프를 확인해야 최종 결과가 나오는 형태임

    @FXML
    private Button backBtn;

    @FXML
    private Text messageText;

    private boolean isSuitable = false;

    private Town town;
    private Village village;
    private Sectors sectors;



    public void initialize() {

    }
    private String makeMessage(){
        String message = "";
        message += town + " ";  //@@시
        message += village+ "에 \n";     //@@동에
        message += sectors + "은 \n" ;    //@@은

        if(isSuitable)
        {
            message += "적합합니다.";
        }
        else {
            message += "적합하지 않습니다.";
        }
        return  message;
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
        primaryStage.setTitle("최종 결과 분석 페이지");
        primaryStage.setWidth(600);
        primaryStage.setHeight(400);
        //mainPageController.initialize();
    }
    public void initData(Town town, Village village, Sectors sectors) {
        this.town = town;
        this.village = village;
        this.sectors = sectors;
        String message = null;
        messageText.setText(ClientApp.text + "\n" + ClientApp.text2);
    }
}
