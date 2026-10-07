package com.mygroup.controllers;

import com.mygroup.models.GroupModel;
import com.mygroup.models.SpecialityModel;
import com.mygroup.repositories.GroupRepository;
import com.mygroup.repositories.SpecialityRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;


public class AddGroupController extends BaseAddController {
    public TextField groupField;
    @FXML
    private ChoiceBox<SpecialityModel> specialityBox;
    @FXML
    private Spinner<Integer> courseSpinner;


    private final GroupRepository groupRepository;

    public AddGroupController() {
        groupRepository = new GroupRepository();

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
            groupRepository.add(new GroupModel(specialityId, groupField.getText(), courseSpinner.getValue()));
            return true;
        } catch (SQLException e) {
            showErrorWindow("Не удалось добавить новую группу!");
            e.printStackTrace();
            return false;
        }

    }

    public boolean check() {
        if (groupField.getText() == null || groupField.getText().isBlank() ||
                specialityBox.getValue() == null) {
            showErrorWindow("Заполните все поля!");
            return false;
        }
        return true;
    }
}
