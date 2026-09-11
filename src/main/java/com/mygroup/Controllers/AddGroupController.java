package com.mygroup.Controllers;

import com.mygroup.Models.GroupModel;
import com.mygroup.Models.SpecialityModel;
import com.mygroup.Models.TeacherModel;
import com.mygroup.Services.GroupService;
import com.mygroup.Services.SpecialityService;
import com.mygroup.Services.TeacherService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddGroupController extends BaseController{
    @FXML
    private ChoiceBox<String> specialityBox;
    @FXML
    private Spinner<Integer> courseSpinner;
    @FXML
    private Button addButton;

    private GroupService groupService;
    private SpecialityService specialityService;

    public AddGroupController() throws SQLException {
        groupService = new GroupService();
    }

    @FXML
    public void initialize() throws SQLException {
        this.specialityService = new SpecialityService();
        ObservableList<SpecialityModel> specialityModels = specialityService.getAll();

        ObservableList<String> nameOfSpeciality = FXCollections.observableArrayList();
        for (SpecialityModel specialityModel : specialityModels) {
            nameOfSpeciality.add(specialityModel.getName());
        }
        specialityBox.setItems(nameOfSpeciality);

        courseSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 6, 1));
        addButton.setOnAction(actionEvent -> {
            try {
                if (check()) {
                    setData();
                    /*Stage stage = (Stage) addButton.getScene().getWindow();
                    stage.close();*/
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setData() throws SQLException {
        int id = specialityService.getId(specialityBox.getValue());
        System.out.println(id);
        //groupService.add(new GroupModel(nameField.getText(), surnameField.getText(), patField.getText()));
    }

    public boolean check() throws SQLException {
        /*if (nameField.getText() == null || nameField.getText().isBlank() ||
                surnameField.getText() == null || surnameField.getText().isBlank() ||
                patField.getText() == null || patField.getText().isBlank()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Произошла ошибка");
            alert.setContentText(String.format("Заполните все поля"));
            alert.showAndWait();
            return false;
        } */
        return true;
    }
}
