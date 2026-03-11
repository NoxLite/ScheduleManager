package com.mygroup.Controllers;

import com.mygroup.Models.Speciality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Objects;

public class AddSpecialityController {

    @FXML
    public TextField courseField;
    @FXML
    public TextField specialityField;
    public Button addButton;

    public boolean isAdded = false;

    public ObservableList<Speciality> data = FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        addButton.setOnAction(actionEvent -> check());
    }

    public void setData(ObservableList<Speciality> data) {
        this.data = data;
    }

    public void check() {
        if (courseField.getText() == null || Objects.equals(courseField.getText(), "")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Произошла ошибка");
            alert.setContentText(String.format("Введите номер курса"));
            alert.showAndWait();
            return;
        }

        if (specialityField.getText() == null || Objects.equals(specialityField.getText(), "")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Произошла ошибка");
            alert.setContentText(String.format("Введите название специальности"));
            alert.showAndWait();
            return;
        }

        for (Speciality datum : data) {
            if (Objects.equals(datum.getCourse(), getCourse()) && Objects.equals(datum.getName(), getSpeciality())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Произошла ошибка");
                alert.setContentText(String.format("Специальность %s на курсе %d уже существует", getSpeciality(), getCourse()));
                alert.showAndWait();
                return;
            }
        }

        isAdded = true;

        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();

    }

    public Integer getCourse() {
        return Integer.parseInt(courseField.getText());
    }

    public String getSpeciality() {
        return specialityField.getText();
    }
}
