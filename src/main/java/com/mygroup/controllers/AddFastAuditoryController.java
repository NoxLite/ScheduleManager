package com.mygroup.controllers;

import com.mygroup.models.AuditoryModel;
import com.mygroup.repositories.AuditoryRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddFastAuditoryController extends BaseAddController {
    @FXML
    private Label exampleLabel;
    @FXML
    private TextField beforeTextField;
    @FXML
    private TextField startFieldNumber;
    @FXML
    private TextField endNumberField;
    @FXML
    private TextField afterTextField;

    private final AuditoryRepository auditoryRepository;

    public AddFastAuditoryController() {
        auditoryRepository = new AuditoryRepository();
    }

    @Override
    public void initialize() {
        beforeTextField.textProperty().addListener(actionEvent -> update());
        startFieldNumber.textProperty().addListener(actionEvent -> update());
        afterTextField.textProperty().addListener(actionEvent -> update());
        super.initialize();
    }

    @Override
    public boolean setData() {
        try {
            int start = Integer.parseInt(startFieldNumber.getText());
            int end = Integer.parseInt(endNumberField.getText());
            while (start <= end) {
                String text = beforeTextField.getText() + start + afterTextField.getText();
                auditoryRepository.add(new AuditoryModel(text));
                start++;
            }
            return true;
        } catch (SQLException e) {
            showErrorWindow("Не удалось добавить аудиторию");
            return false;
        }
    }

    @Override
    public boolean check() {
        try {
            int start = Integer.parseInt(startFieldNumber.getText());
            int end = Integer.parseInt(endNumberField.getText());

            if (start > end || start < 0) {
                showErrorWindow("Номера аудиторий заполнены некорректно!");
                return false;
            }
            return true;
        } catch (Exception e) {
            showErrorWindow("Номера аудиторий заполнены некорректно!");
            return false;
        }
    }

    private void update() {
        try {
            int start = Integer.parseInt(startFieldNumber.getText());
            String text = beforeTextField.getText() + start + afterTextField.getText();
            exampleLabel.setText(text);
        } catch (Exception e) {
            exampleLabel.setText("Не все поля заполнены корректно");
        }

    }
}
