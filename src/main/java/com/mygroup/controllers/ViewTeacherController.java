package com.mygroup.controllers;

import com.mygroup.models.TeacherModel;
import com.mygroup.repositories.TeacherRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ViewTeacherController extends BaseViewController<TeacherModel, TeacherRepository> {
    @FXML
    private TableColumn<TeacherModel, Integer> idColumn;
    @FXML
    private TableColumn<TeacherModel, String> columnName;
    @FXML
    private TableColumn<TeacherModel, String> columnSurname;
    @FXML
    private TableColumn<TeacherModel, String> columnPatronymic;


    public ViewTeacherController() {
        repository = new TeacherRepository();
        resourceForAddWindow = "/addTeacher.fxml";
    }

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        columnName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        columnSurname.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSurname()));
        columnPatronymic.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPatronymic()));

        super.initialize();
    }
}
