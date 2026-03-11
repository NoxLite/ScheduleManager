package com.mygroup.Controllers;

import com.mygroup.BaseWindow;
import com.mygroup.Models.Speciality;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainController {

    private final ObservableList<Speciality> tableData = FXCollections.observableArrayList();

    @FXML
    public Button addButton;
    @FXML
    public TableView<Speciality> specialityTable;

    public TableColumn<Speciality, Integer> columnCourse;
    public TableColumn<Speciality, String> columnName;

    @FXML
    public void initialize() {
        tableData.add(new Speciality(1, "S1"));
        tableData.add(new Speciality(1, "S2"));
        specialityTable.setItems(tableData);

        columnName.setCellValueFactory(c -> c.getValue().nameProperty());
        columnCourse.setCellValueFactory(c -> c.getValue().courseProperty().asObject());

        addButton.setOnAction(actionEvent -> {
            try {
                openWindow();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void openWindow() throws IOException {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/base.fxml")));
        Parent scene = loader.load();
        AddSpecialityController controller = loader.getController();
        controller.setData(tableData);
        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.showAndWait();

        if (controller.isAdded) {
            tableData.add(new Speciality(controller.getCourse(), controller.getSpeciality()));
            specialityTable.setItems(tableData);
        }

    }

}
