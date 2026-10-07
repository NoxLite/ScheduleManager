package com.mygroup.controllers;

import com.mygroup.models.StudyPlanViewModel;
import com.mygroup.repositories.StudyPlanViewRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ViewStudyPlanController extends BaseViewController<StudyPlanViewModel, StudyPlanViewRepository> {
    @FXML
    private TableColumn<StudyPlanViewModel, Integer> columnId;
    @FXML
    private TableColumn<StudyPlanViewModel, String> columnName;
    @FXML
    private TableColumn<StudyPlanViewModel, String> specialityColumn;
    @FXML
    private TableColumn<StudyPlanViewModel, Integer> courseColumn;

    public ViewStudyPlanController() {
        repository = new StudyPlanViewRepository();
        resourceForAddWindow = "/addStudyPlan.fxml";
    }

    @Override
    public void initialize() {
        columnId.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getId()).asObject());
        columnName.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getName()));
        specialityColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getSpecialityName()));
        courseColumn.setCellValueFactory(c -> new SimpleIntegerProperty(c.getValue().getCourse()).asObject());
        super.initialize();
    }
}
