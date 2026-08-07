package com.mygroup.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.sql.SQLException;

public class MainWindowController {
    @FXML
    private StackPane stackPane;
    @FXML
    private Button specialityButton;

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

    public void speciality() throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viewSpeciality.fxml"));
        Parent parent = fxmlLoader.load();

        ViewSpecialityController viewSpecialityController = fxmlLoader.getController();
        viewSpecialityController.visualize();

        stackPane.getChildren().clear();
        stackPane.getChildren().add(parent);
    }
}
