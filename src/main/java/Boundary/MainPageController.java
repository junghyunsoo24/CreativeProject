package Boundary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import Enum.Town;
import Enum.Village;
import Enum.Sectors;

import java.io.IOException;


public class MainPageController {
    @FXML
    private ChoiceBox<String> townChoiceBox;
    @FXML
    private ChoiceBox<String> villageChoiceBox;
    @FXML
    private ChoiceBox<String> sectorsChoiceBox;

    private String choosedTown;
    private String choosedVillage;
    private String choosedSectors;

    @FXML
    private Button startBtn;
    @FXML
    private Button loginBtn;
    public void initialize() {
        initChoiceBox();
        choiceBoxAction();
    }
    private void initChoiceBox()
    {
        ObservableList<String> townItems = FXCollections.observableArrayList(
                Town.대전광역시.toString()
        );
        townChoiceBox.setItems(townItems);

        ObservableList<String> villageItems = FXCollections.observableArrayList();
        for(Village village : Village.getList()){
            villageItems.add(village.getName());
        }
        villageChoiceBox.setItems(villageItems);

        ObservableList<String> sectorItems = FXCollections.observableArrayList();
        for(Sectors sectors : Sectors.getList()){
            sectorItems.add(sectors.getIndustry());
        }
        villageChoiceBox.setItems(villageItems);
    }
    private void choiceBoxAction()
    {
        // 선택 이벤트 처리
        townChoiceBox.setOnAction(event -> {
            choosedTown = townChoiceBox.getValue();
        });
        villageChoiceBox.setOnAction(event -> {
            choosedVillage = villageChoiceBox.getValue();
        });
        sectorsChoiceBox.setOnAction(event -> {
            choosedSectors = sectorsChoiceBox.getValue();
        });
    }

    @FXML
    private void handleStartBtn() throws IOException
    {
        Parent otherPage = FXMLLoader.load(getClass().getResource("ChoosePage.fxml"));
        //ChoosePageController choosePageController = FXMLLoader.getController();

        Scene currentScene = startBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Choose Page");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //choosePageController.initialize(choosedTown,choosedVillage, choosedSectors );
    }

    @FXML
    private void handleLoginBtn() throws IOException
    {
        Parent otherPage = FXMLLoader.load(getClass().getResource("ManagerLoginPage.fxml"));
        //LoginPageController choosePageController = FXMLLoader.getController();

        Scene currentScene = loginBtn.getScene();
        currentScene.setRoot(otherPage);
        Stage primaryStage = (Stage) currentScene.getWindow();
        primaryStage.setTitle("Login Page");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        //LoginPageController.initialize();
    }


}
