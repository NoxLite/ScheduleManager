package com.mygroup.controllers;

import com.mygroup.models.BaseModel;

import com.mygroup.repositories.BaseRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class BaseViewController<T extends BaseModel, A extends BaseRepository<T>> extends BaseController {
    @FXML
    protected Button addButton;
    @FXML
    protected Button deleteButton;
    @FXML
    protected TableView<T> tableView;

    protected A repository;

    protected String resourceForAddWindow = "helloWindow.fxml";

    @FXML
    public void initialize() {
        addButton.setOnAction(actionEvent -> {
            openWindow();
            visualize();
        });
        deleteButton.setOnAction(actionEvent -> {
            delete();
            visualize();
        });

        visualize();
    }

    private void openWindow() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(resourceForAddWindow)));
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

    protected void delete() {
        try {
            T groupModel = tableView.getSelectionModel().getSelectedItem();
            if (groupModel != null) {
                repository.delete(groupModel.getId());
            }
        } catch (SQLException e) {
            showErrorWindow("Не удалось удалить");
            e.printStackTrace();
        }
    }

    public void visualize() {
        try {
            ObservableList<T> data = FXCollections.observableArrayList(repository.getAll());
            tableView.setItems(data);
        } catch (SQLException e) {
            showErrorWindow("Не удалось обновить окно");
            e.printStackTrace();
        }

    }
}
