package com.mygroup.controllers;

import com.mygroup.models.TeacherModel;
import com.mygroup.repositories.TeacherRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;


public class AddTeacherController extends BaseAddController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField patField;

    private final TeacherRepository teacherService;

    public AddTeacherController() {
        teacherService = new TeacherRepository();
    }

    public boolean setData() {
        try {
            teacherService.add(new TeacherModel(nameField.getText(), surnameField.getText(), patField.getText()));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorWindow("Не удалось добавить преподавателя");
            return false;
        }
    }

    public boolean check() {
        if (nameField.getText() == null || nameField.getText().isBlank() ||
                surnameField.getText() == null || surnameField.getText().isBlank() ||
                patField.getText() == null || patField.getText().isBlank()) {
            showErrorWindow("Заполните все поля!");
            return false;
        }
        return true;
    }
}
