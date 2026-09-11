package com.mygroup.Controllers;

import com.mygroup.Models.GroupModel;
import com.mygroup.Services.GroupService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import com.mygroup.Models.GroupModel;
import com.mygroup.Models.TeacherModel;
import com.mygroup.Services.GroupService;
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

public class ViewGroupController extends BaseController {
    @FXML
    private Button addButton;
    @FXML
    private TableView<GroupModel> groupTable;
    @FXML
    private TableColumn<GroupModel, Integer> columnId;
    @FXML
    private TableColumn<GroupModel, String> columnSpeciality;
    @FXML
    private TableColumn<GroupModel, String> columnGroup;
    @FXML
    private TableColumn<GroupModel, String> columnCourse;

    private ObservableList data = FXCollections.observableArrayList();

    private GroupService groupService;

    public ViewGroupController() throws SQLException {
        groupService = new GroupService();
    }

    @FXML
    public void initialize() throws SQLException {
        addButton.setOnAction(actionEvent -> {
            try {
                openWindow();
                visualize();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
    //@todo: изменить
    private void openWindow() throws IOException, SQLException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/addGroup.fxml")));
        Parent scene = loader.load();

        stage.setScene(new Scene(scene));
        stage.setResizable(false);
        stage.showAndWait();
    }

    private void delete() throws SQLException {
        GroupModel groupModel = groupTable.getSelectionModel().getSelectedItem();
        if (groupModel != null) {
            groupService.delete(groupModel.getId());
        }
    }
    //@todo: сделать так чтобы показывалось наименование специальности а не id
    public void visualize() throws SQLException {
        this.data = groupService.getAll();
        groupTable.setItems(data);
    }


}