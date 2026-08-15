package com.mygroup.Controllers;

import com.mygroup.Models.SpecialityModel;
import com.mygroup.Models.TeacherModel;
import com.mygroup.Services.TeacherService;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Callback;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class ViewTeacherController extends BaseController {
    @FXML
    private TableView<TeacherModel> table;
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableColumn<TeacherModel, Integer> idColumn;
    @FXML
    private TableColumn<TeacherModel, String> columnName;
    @FXML
    private TableColumn<TeacherModel, String> columnSurname;
    @FXML
    private TableColumn<TeacherModel, String> columnPatronymic;

    private ObservableList<TeacherModel> tableData = FXCollections.observableArrayList();
    private final TeacherService teacherService;

    public ViewTeacherController() throws SQLException {
        teacherService = new TeacherService();
    }

    @FXML
    public void initialize() throws SQLException {
        idColumn.setCellValueFactory(c -> c.getValue().idProperty().asObject());
        columnName.setCellValueFactory(c -> c.getValue().nameProperty());
        columnSurname.setCellValueFactory(c -> c.getValue().surnameProperty());
        columnPatronymic.setCellValueFactory(c -> c.getValue().patronymicProperty());

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
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/addTeacher.fxml")));
        Parent scene = loader.load();

        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.showAndWait();
    }

    private void delete() throws SQLException {
        TeacherModel teacherModel = table.getSelectionModel().getSelectedItem();
        if (teacherModel != null) {
            teacherService.delete(teacherModel.getId());
        }
    }

    public void visualize() throws SQLException {
        this.tableData = teacherService.getAll();
        table.setItems(tableData);
    }
}
