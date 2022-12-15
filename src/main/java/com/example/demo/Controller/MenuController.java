package com.example.demo.Controller;

import java.io.IOException;

import com.example.demo.UserSettings;
import com.example.demo.Objects.Account;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private VBox menuVBox;

    @FXML
    private Text menuTitle;

    @FXML
    private Button settingsBtn;

    @FXML
    private Button startBtn;

    @FXML
    private Button leaderboardBtn;

    /**
     * onAction Event for the button specified in the FXML
     * Button will start the game by creating the game scene
     * 
     * @param event argument event given by the FXML to Controller class
     */
    @FXML
    void startGame(ActionEvent event) throws IOException {
        // Gets primary stage from vBox
        Stage primaryStage = (Stage) menuVBox.getScene().getWindow();
        FXMLLoader gameLoad = new FXMLLoader(getClass().getResource("../Scenes/GameScene.fxml"));
        Parent gameRoot = gameLoad.load();
        GameController gameController = gameLoad.getController();
        gameController.setPrevScene(menuVBox.getScene());
        primaryStage.setScene(new Scene(gameRoot, UserSettings.HEIGHT, UserSettings.WIDTH, Color.rgb(189, 177, 92)));
        primaryStage.show();
    }

    @FXML
    void openLeaderboard(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) menuVBox.getScene().getWindow();
        FXMLLoader lbLoad = new FXMLLoader(getClass().getResource("../Scenes/Leaderboard.fxml"));
        Parent lbRoot = lbLoad.load();
        LeaderboardController lbControl = lbLoad.getController();
        lbControl.setPrevScene(menuVBox.getScene());
        primaryStage.setScene(new Scene(lbRoot, UserSettings.HEIGHT, UserSettings.WIDTH));
        primaryStage.show();
    }

    @FXML
    void openSettings(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) menuVBox.getScene().getWindow();
        FXMLLoader settingsLoad = new FXMLLoader(getClass().getResource("../Scenes/SettingsScene.fxml"));
        Parent settingsRoot = settingsLoad.load();
        SettingsController settingsController = settingsLoad.getController();
        settingsController.setPrevScene(menuVBox.getScene());
        primaryStage.setScene(new Scene(settingsRoot, UserSettings.HEIGHT, UserSettings.WIDTH));
        primaryStage.show();
    }   

    @FXML
    void quitMenu(ActionEvent event) throws IOException{
        // Update the scorelist first
        Account.updateFile();
        Platform.exit();
        System.exit(0);
    }

}