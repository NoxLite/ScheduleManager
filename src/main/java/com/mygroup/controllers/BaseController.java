package com.mygroup.controllers;

import javafx.scene.control.Alert;

public class BaseController {
    public void showErrorWindow(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ошибка");
        alert.setContentText(content);
        alert.showAndWait();
    }
}
