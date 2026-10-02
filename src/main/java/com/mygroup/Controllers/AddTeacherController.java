package com.mygroup.Controllers;

import com.mygroup.Models.SpecialityModel;
import com.mygroup.Models.TeacherModel;
import com.mygroup.Services.TeacherService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddTeacherController extends BaseController {

    @FXML
    private Button addButton;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField patField;

    private TeacherService teacherService;

    public AddTeacherController() throws SQLException{
        teacherService = new TeacherService();
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
        teacherService.add(new TeacherModel(nameField.getText(), surnameField.getText(), patField.getText()));
    }

    public boolean check() {
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
    }
}
