package com.mygroup.Controllers;


import com.mygroup.Models.SpecialityModel;
import com.mygroup.Services.SpecialityService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.Objects;

public class AddSpecialityController extends BaseController{
    @FXML
    private TextField specialityField;
    @FXML
    private Button addButton;

    private final SpecialityService specialityService;

    public AddSpecialityController() throws SQLException {
        specialityService = new SpecialityService();
    }

    @FXML
    public void initialize() {
        addButton.setOnAction(actionEvent -> {
            try {
                if (check()) {
                    setData();
                    Stage stage = (Stage) addButton.getScene().getWindow();
                    stage.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setData() throws SQLException {
        specialityService.add(new SpecialityModel(specialityField.getText()));
    }

    public boolean check() {
        if (specialityField.getText() == null || specialityField.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Произошла ошибка");
            alert.setContentText(String.format("Введите название специальности"));
            alert.showAndWait();
            return false;
        }
        return true;
    }
}
