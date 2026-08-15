package com.mygroup.Controllers;

import com.mygroup.Models.GroupModel;
import com.mygroup.Models.TeacherModel;
import com.mygroup.Services.GroupService;
import com.mygroup.Services.TeacherService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddGroupController extends BaseController{
    @FXML
    private Button addButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField patField;

    private GroupService groupService;

    public AddGroupController() throws SQLException {
        groupService = new GroupService();
    }
    /*
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
    } */

    /* public void setData() throws SQLException {
        groupService.add(new GroupModel(nameField.getText(), surnameField.getText(), patField.getText()));
    }

    public boolean check() throws SQLException {
        if (nameField.getText() == null || nameField.getText().isBlank() ||
                surnameField.getText() == null || surnameField.getText().isBlank() ||
                patField.getText() == null || patField.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Произошла ошибка");
            alert.setContentText(String.format("Заполните все поля"));
            alert.showAndWait();
            return false;
        }
        return true;
    } */
}
