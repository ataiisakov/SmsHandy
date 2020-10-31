package controllers;

import app.Main;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {
    private Stage mainStage;
    private Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    public void handleClose(){
        mainStage.close();
    }

    @FXML
    public void showProviders() throws IOException {
        main.switchToProviderView();
    }

    @FXML
    public void showAbonents() throws IOException {
        main.switchToAbonentsView();
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }
}
