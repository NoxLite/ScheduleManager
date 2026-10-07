package com.mygroup.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BaseAddController extends BaseController {
    @FXML
    protected Button addButton;

    @FXML
    public void initialize() {
        addButton.setOnAction(actionEvent -> {
            if (check()) {
                if (setData()) {
                    Stage stage = (Stage) addButton.getScene().getWindow();
                    stage.close();
                }
            }
        });
    }

    public boolean check() {
        return true;
    }

    public boolean setData() {
        return true;
    }
}
