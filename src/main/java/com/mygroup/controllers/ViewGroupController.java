package com.mygroup.controllers;

import com.mygroup.models.GroupViewModel;

import com.mygroup.repositories.GroupViewRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;


public class ViewGroupController extends BaseViewController<GroupViewModel, GroupViewRepository> {
    @FXML
    private TableColumn<GroupViewModel, Integer> columnId;
    @FXML
    private TableColumn<GroupViewModel, String> columnSpeciality;
    @FXML
    private TableColumn<GroupViewModel, String> columnGroup;
    @FXML
    private TableColumn<GroupViewModel, Integer> columnCourse;

    public ViewGroupController() {
         repository = new GroupViewRepository();
         resourceForAddWindow = "/addGroup.fxml";
    }

    @FXML
    public void initialize() {
        columnId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        columnSpeciality.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSpeciality()));
        columnGroup.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        columnCourse.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCourse()).asObject());


        super.initialize();
    }

}