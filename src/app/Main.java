package app;

import controllers.MainViewController;
import controllers.ProviderViewController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Provider;

import java.io.IOException;

public class Main extends Application {
    private Stage mainStage;
    private BorderPane mainPane;
    private ObservableList<Provider> providers = FXCollections.observableArrayList();

    public Main() {
        providers.add(new Provider("MegaCom"));
        providers.add(new Provider("Beeline"));
        providers.add(new Provider("O!"));
    }

    public ObservableList<Provider> getProviders() {
        return providers;
    }

    public static void main(String[] args) {
        launch(args);
       
    }

    public void switchToProviderView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\views\\provider_view.fxml"));
        AnchorPane pane = loader.load();
        mainPane.setCenter(pane);

        ProviderViewController controller = loader.getController();
        controller.setMain(this);

    }

    public void switchToAbonentsView() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\views\\abonents_view.fxml"));
        AnchorPane pane = loader.load();
        mainPane.setCenter(pane);

    }
    @Override
    public void start(Stage stage) throws Exception {
        mainStage = stage;
        mainStage.setTitle("Window");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\views\\main_view.fxml"));
        mainPane = loader.load();
        Scene scene = new Scene(mainPane);
        mainStage.setScene(scene);

        MainViewController controller = loader.getController();
        controller.setMainStage(mainStage);
        controller.setMain(this);

        mainStage.show();
    }
}
