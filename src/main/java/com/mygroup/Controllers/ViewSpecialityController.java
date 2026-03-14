package com.mygroup.Controllers;

import com.mygroup.Contexts.SpecialityContext;
import com.mygroup.Models.SpecialityModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ViewSpecialityController {

    private ObservableList<SpecialityModel> tableData = FXCollections.observableArrayList();

    @FXML
    public Button addButton;
    @FXML
    public TableView<SpecialityModel> specialityTable;

    public TableColumn<SpecialityModel, Integer> columnCourse;
    public TableColumn<SpecialityModel, String> columnName;
    public Button deleteButton;

    private SpecialityContext specialityContext;

    @FXML
    public void initialize() {


        columnName.setCellValueFactory(c -> c.getValue().nameProperty());
        columnCourse.setCellValueFactory(c -> c.getValue().courseProperty().asObject());

        addButton.setOnAction(actionEvent -> {
            try {
                openWindow();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        });

        deleteButton.setOnAction(actionEvent -> {
            try {
                delete();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void openWindow() throws IOException, SQLException {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/addSpeciality.fxml")));
        Parent scene = loader.load();
        AddSpecialityController controller = loader.getController();
        controller.setData(tableData);
        controller.specialityContext = specialityContext;
        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.showAndWait();

        visualize();
    }

    public void setSpecialityContext(SpecialityContext specialityContext) {
        this.specialityContext = specialityContext;
    }

    public void delete() throws SQLException {
        SpecialityModel specialityModel = specialityTable.getSelectionModel().getSelectedItem();
        specialityContext.specialityService.delete(specialityModel);
        visualize();
    }

    public void visualize() throws SQLException {
        this.tableData = specialityContext.specialityService.getAll();

        specialityTable.setItems(tableData);
    }

}
