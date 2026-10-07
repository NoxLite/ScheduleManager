package com.mygroup.controllers;

import com.mygroup.models.SpecialityModel;
import com.mygroup.repositories.SpecialityRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import java.sql.SQLException;


public class AddSpecialityController extends BaseAddController {
    @FXML
    private Spinner<Integer> durationSpinner;
    @FXML
    private TextField specialityField;

    private final SpecialityRepository specialityService;

    public AddSpecialityController() {
        specialityService = new SpecialityRepository();
    }

    @Override
    public void initialize() {
        durationSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 1));
        super.initialize();
    }

    public boolean setData() {
        try {
            specialityService.add(new SpecialityModel(specialityField.getText(), durationSpinner.getValue()));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            showErrorWindow("Не удалось специальность");
            return false;
        }
    }

    public boolean check() {
        if (specialityField.getText() == null || specialityField.getText().isBlank()) {
            showErrorWindow("Заполните все поля!");
            return false;
        }
        return true;
    }
}
