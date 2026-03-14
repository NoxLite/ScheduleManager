package com.mygroup;

import com.mygroup.Contexts.SpecialityContext;
import com.mygroup.Controllers.ViewSpecialityController;
import com.mygroup.SavesAndBases.DatabaseLoader;
import com.mygroup.Services.AddSpecialityService;
import com.mygroup.Services.SpecialityService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.SQLException;


public class Main extends Application {
    private static SpecialityContext specialityContext;

    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseLoader.run("jdbc:sqlite:./src/main/java/com/mygroup/databases/base.db");

        SpecialityService specialityService = new SpecialityService(connection);
        AddSpecialityService addSpecialityService = new AddSpecialityService(connection);

        specialityContext = new SpecialityContext(specialityService, addSpecialityService);

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/mainWindow.fxml"));
        Parent parent = fxmlLoader.load();

        /*ViewSpecialityController viewSpecialityController = fxmlLoader.getController();
        viewSpecialityController.setSpecialityContext(specialityContext);
        viewSpecialityController.visualize(); */

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
