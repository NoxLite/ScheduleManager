package com.mygroup.Controllers;

import com.mygroup.Contexts.MainContext;
import com.mygroup.Contexts.SpecialityContext;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.sql.SQLException;

public class BaseController {

    public StackPane stackPane;
    public MainContext mainContext;
    public Button specialityButton;

    @FXML
    public void initialize() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/helloWindow.fxml"));
        Parent parent = fxmlLoader.load();

        stackPane.getChildren().add(parent);

        specialityButton.setOnAction(actionEvent -> {
            try {
                speciality();
            } catch (IOException | SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void setContext(MainContext mainContext) {
        this.mainContext = mainContext;
    }

    public void speciality() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewSpeciality.fxml"));
        Parent parent = fxmlLoader.load();

        ViewSpecialityController viewSpecialityController = fxmlLoader.getController();
        viewSpecialityController.setSpecialityContext(new SpecialityContext(
                mainContext.specialityService, mainContext.addSpecialityService
        ));
        viewSpecialityController.visualize();

        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
}
