package controllers;

import app.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import models.Provider;

public class ProviderViewController {

    private Main main;

    @FXML
    private Label abonAmountLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TableColumn<Provider,String> providerNameColumn;

    @FXML
    private TableView<Provider> providersTableView;

    @FXML
    private void initialize(){
        providerNameColumn.setCellValueFactory(cellValue->
                new SimpleStringProperty(cellValue.getValue().getName()));

        providersTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable,oldValue,newValue)-> showProviderInfo(newValue));
    }

    @FXML
    public void handleDeleteProvider(){

    }
    @FXML
    public void handleCreateProvider(){

    }
    @FXML
    public void handleEditProvider(){

    }

    public void showProviderInfo(Provider provider){
        if (provider != null){
            nameLabel.setText(provider.getName());
            abonAmountLabel.setText(""+provider.getAbonentsMap().size());
        }else {
            nameLabel.setText("не выбран");
            abonAmountLabel.setText("не выбран");
        }
    }

    public void setMain(Main main) {
        this.main = main;
        providersTableView.setItems(main.getProviders());

    }
}
