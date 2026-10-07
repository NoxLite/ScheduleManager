package com.mygroup.controllers;

import com.mygroup.models.SpecialityModel;
import com.mygroup.models.StudyPlanModel;
import com.mygroup.repositories.SpecialityRepository;
import com.mygroup.repositories.StudyPlanRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddStudyPlanController extends BaseAddController {
    @FXML
    private TextField subjectField;
    @FXML
    private ChoiceBox<SpecialityModel> specialityBox;
    @FXML
    private Spinner<Integer> courseSpinner;

    public StudyPlanRepository studyPlanRepository;

    public AddStudyPlanController() {
        studyPlanRepository = new StudyPlanRepository();
    }

    @FXML
    public void initialize() {
        super.initialize();
        try {
            SpecialityRepository specialityService = new SpecialityRepository();
            ObservableList<SpecialityModel> specialityModels = FXCollections.observableArrayList(specialityService.getAll());

            specialityBox.setItems(specialityModels);
            specialityBox.setOnAction(observable -> courseSpinner.setValueFactory(new
                                    SpinnerValueFactory.IntegerSpinnerValueFactory(
                                    1, specialityBox.getSelectionModel().getSelectedItem().getDuration(), 1
                            )
                    )
            );
            courseSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 1));
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorWindow("Не удалось загрузить окно добавления");
        }
    }

    public boolean setData() {
        try {
            int specialityId = specialityBox.getSelectionModel().getSelectedItem().getId();
            studyPlanRepository.add(new StudyPlanModel(subjectField.getText(), specialityId, courseSpinner.getValue()));
            return true;
        } catch (SQLException e) {
            showErrorWindow("Не удалось добавить новый предмет!");
            e.printStackTrace();
            return false;
        }
    }

    public boolean check() {
        if (subjectField.getText() == null || subjectField.getText().isBlank() ||
                specialityBox.getValue() == null) {
            showErrorWindow("Заполните все поля!");
            return false;
        }
        return true;
    }
}
