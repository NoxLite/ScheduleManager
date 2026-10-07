package com.mygroup.controllers;

import com.mygroup.models.AuditoryModel;
import com.mygroup.repositories.AuditoryRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ViewAuditoryController extends BaseViewController<AuditoryModel, AuditoryRepository> {
    @FXML
    private Button addFastButton;
    @FXML
    private TableColumn<AuditoryModel, String> columnName;
    @FXML
    private TableColumn<AuditoryModel, Integer> columnId;

    public ViewAuditoryController() {
        repository = new AuditoryRepository();
        resourceForAddWindow = "/addAuditory.fxml";
    }

    @Override
    public void initialize() {
        columnId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        columnName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        addFastButton.setOnAction(actionEvent -> {
            openAddFastWindow();
            visualize();
        });
        super.initialize();
    }

    private void openAddFastWindow() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/addFastAuditory.fxml")));
            Parent scene = loader.load();

            stage.setScene(new Scene(scene));
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            showErrorWindow("Не удалось открыть окно");
            e.printStackTrace();
        }
    }
}
