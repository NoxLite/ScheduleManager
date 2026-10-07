package com.mygroup.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;


public class MainWindowController extends BaseController {
    @FXML
    public Button studyPlan;
    @FXML
    private Button auditoryButton;
    @FXML
    private Button homeButton;
    @FXML
    private Button groupButton;
    @FXML
    private StackPane stackPane;
    @FXML
    private Button specialityButton;
    @FXML
    private Button teacherButton;

    private static final String viewHomeWindowResource = "/helloWindow.fxml";
    private static final String viewSpecialityResource = "/viewSpeciality.fxml";
    private static final String viewTeacherResource = "/viewTeacher.fxml";
    private static final String viewGroupResource = "/viewGroup.fxml";
    private static final String viewAuditoryResource = "/viewAuditory.fxml";
    private static final String viewStudyPlanResource = "/viewStudyPlan.fxml";

    @FXML
    public void initialize() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(viewHomeWindowResource));
        try {
            Parent parent = fxmlLoader.load();
            stackPane.getChildren().add(parent);
        } catch (IOException e) {
            showErrorWindow(e.getMessage());
        }

        homeButton.setOnAction(actionEvent -> openChapter(viewHomeWindowResource));

        specialityButton.setOnAction(actionEvent ->
            openChapter(viewSpecialityResource)
        );

        teacherButton.setOnAction(actionEvent ->
            openChapter(viewTeacherResource)
        );

        groupButton.setOnAction(actionEvent ->
            openChapter(viewGroupResource)
        );

        auditoryButton.setOnAction(actionEvent ->
                openChapter(viewAuditoryResource)
        );

        studyPlan.setOnAction(actionEvent ->
                openChapter(viewStudyPlanResource)
        );
    }

    public void openChapter(String resource) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
            Parent parent = fxmlLoader.load();

            stackPane.getChildren().clear();
            stackPane.getChildren().add(parent);
        } catch (IOException e) {
            e.printStackTrace();
            showErrorWindow("Не удалось запустить");

        }
    }
}

