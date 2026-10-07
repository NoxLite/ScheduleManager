package com.mygroup.controllers;

import com.mygroup.models.SpecialityModel;
import com.mygroup.repositories.SpecialityRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ViewSpecialityController extends BaseViewController<SpecialityModel, SpecialityRepository> {

    @FXML
    private TableColumn<SpecialityModel, Integer> columnId;
    @FXML
    private TableColumn<SpecialityModel, String> columnName;
    @FXML
    private TableColumn<SpecialityModel, Integer> columnDuration;


    public ViewSpecialityController() {
        this.repository = new SpecialityRepository();
        this.resourceForAddWindow = "/addSpeciality.fxml";
    }

    @FXML
    public void initialize() {
        columnName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        columnId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        columnDuration.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getDuration()).asObject());

        super.initialize();
    }

}
