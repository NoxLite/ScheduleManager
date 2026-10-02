package com.mygroup.Controllers;

import com.mygroup.Models.GroupViewModel;
import com.mygroup.Services.GroupService;
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

public class ViewGroupController extends BaseController {
    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<GroupViewModel> groupTable;
    @FXML
    private TableColumn<GroupViewModel, Integer> columnId;
    @FXML
    private TableColumn<GroupViewModel, String> columnSpeciality;
    @FXML
    private TableColumn<GroupViewModel, String> columnGroup;
    @FXML
    private TableColumn<GroupViewModel, Integer> columnCourse;

    private ObservableList data = FXCollections.observableArrayList();

    private final GroupService groupService;

    private SpecialityService specialityService = new SpecialityService();

    public ViewGroupController() throws SQLException {
        groupService = new GroupService();
    }

    @FXML
    public void initialize() throws SQLException {
        columnId.setCellValueFactory(c -> c.getValue().idProperty().asObject());
        columnSpeciality.setCellValueFactory(c -> c.getValue().specialityProperty());
        columnGroup.setCellValueFactory(c -> c.getValue().nameProperty());
        columnCourse.setCellValueFactory(c -> c.getValue().courseProperty().asObject());
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
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/addGroup.fxml")));
        Parent scene = loader.load();

        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }

    private void delete() throws SQLException {
        GroupViewModel groupModel = groupTable.getSelectionModel().getSelectedItem();
        if (groupModel != null) {
            groupService.delete(groupModel.getId());
        }
    }

    public void visualize() throws SQLException {


        this.data = groupService.getAll();
        groupTable.setItems(data);
    }
}