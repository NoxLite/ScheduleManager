package com.mygroup.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.sql.SQLException;


public class MainWindowController{
    @FXML
    private Button groupButton;
    @FXML
    private StackPane stackPane;
    @FXML
    private Button specialityButton;
    @FXML
    private Button teacherButton;

    private static final String viewSpecialityResource = "/viewSpeciality.fxml";
    private static final String viewTeacherResource = "/viewTeacher.fxml";
    private static final String viewGroupResource = "/viewGroup.fxml";

    @FXML
    public void initialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/helloWindow.fxml"));
        Parent parent = fxmlLoader.load();

        stackPane.getChildren().add(parent);

        specialityButton.setOnAction(actionEvent -> {
            try {
                openChapter(viewSpecialityResource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        teacherButton.setOnAction(actionEvent -> {
            try {
                openChapter(viewTeacherResource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        groupButton.setOnAction(actionEvent -> {
            try {
                openChapter(viewGroupResource);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

    }

    public void openChapter(String resource) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
        Parent parent = fxmlLoader.load();

        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
}

