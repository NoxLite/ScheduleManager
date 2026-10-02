package com.mygroup.Controllers;


import com.mygroup.Models.SpecialityModel;
import com.mygroup.Services.SpecialityService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ViewSpecialityController extends BaseController{

    private ObservableList<SpecialityModel> tableData = FXCollections.observableArrayList();

    @FXML
    private Button addButton;
    @FXML
    private TableView<SpecialityModel> specialityTable;
    @FXML
    private Button deleteButton;
    @FXML
    private TableColumn<SpecialityModel, Integer> columnId;
    @FXML
    private TableColumn<SpecialityModel, String> columnName;

    private SpecialityService specialityService;

    public ViewSpecialityController() throws SQLException {
        this.specialityService = new SpecialityService();
    }

    @FXML
    public void initialize() throws SQLException {
        columnName.setCellValueFactory(c -> c.getValue().nameProperty());
        columnId.setCellValueFactory(c -> c.getValue().idProperty().asObject());

        addButton.setOnAction(actionEvent -> {
            try {
                openWindow();
                visualize();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        });

        deleteButton.setOnAction(actionEvent -> {
            try {
                delete();
                visualize();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        visualize();
    }

    private void openWindow() throws IOException, SQLException {

        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/addSpeciality.fxml")));
        Parent scene = loader.load();

        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    public void delete() throws SQLException {
        SpecialityModel specialityModel = specialityTable.getSelectionModel().getSelectedItem();
        if (specialityModel != null) {
            specialityService.delete(specialityModel.getId());
        }

    }

    public void visualize() throws SQLException {
        this.tableData = specialityService.getAll();
        specialityTable.setItems(tableData);
    }

}
