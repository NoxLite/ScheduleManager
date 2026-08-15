package com.mygroup.Controllers;


import com.mygroup.Models.BaseModel;
import com.mygroup.Models.SpecialityModel;
import com.mygroup.SavesAndBases.DatabaseManager;
import com.mygroup.Services.BaseService;
import com.mygroup.Services.SpecialityService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.List;

public class AddWindowController extends BaseController{
    @FXML
    public GridPane gridPane;
    public Button addButton = new Button("Добавить");

    private BaseService service;
    private String nameModel;

    //private final SpecialityService specialityService;

    @FXML
    public void initialize() throws SQLException {
        /*addButton.setOnAction(actionEvent -> {
            try {
                if (check()) {
                    setData();
                    Stage stage = (Stage) addButton.getScene().getWindow();
                    stage.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });*/

    }

    public void setNameModel(String nameModel) {
        this.nameModel = nameModel;
    }

    public void setVisible() throws SQLException {
        int count = DatabaseManager.getCountFields(nameModel);
        for (int i = 0; i < count; i++) {
            gridPane.addRow(i, new VBox(), new TextField());
        }
        gridPane.addRow(count + 1, new VBox(), addButton); // <- @todo:надо кнопку расположить по правому краю :(
    }
}
