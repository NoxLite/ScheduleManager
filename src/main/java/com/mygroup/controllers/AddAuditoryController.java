package com.mygroup.controllers;

import com.mygroup.models.AuditoryModel;
import com.mygroup.repositories.AuditoryRepository;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddAuditoryController extends BaseAddController {
    @FXML
    private TextField nameField;

    private final AuditoryRepository auditoryRepository;

    public AddAuditoryController() {
        auditoryRepository = new AuditoryRepository();
    }

    @Override
    public boolean setData() {
        try {
            auditoryRepository.add(new AuditoryModel(nameField.getText()));
            return true;
        } catch (SQLException e) {
            showErrorWindow("Не удалось добавить аудиторию");
            return false;
        }
    }

    @Override
    public boolean check() {
        if (nameField.getText() == null || nameField.getText().isBlank()) {
            showErrorWindow("Заполните все поля!");
            return false;
        }
        return true;
    }
}
