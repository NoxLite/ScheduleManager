package com.mygroup;

import com.mygroup.Contexts.MainContext;
import com.mygroup.Contexts.SpecialityContext;
import com.mygroup.Controllers.BaseController;
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
    private static MainContext mainContext;

    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseLoader.run("jdbc:sqlite:./src/main/java/com/mygroup/databases/base.db");

        SpecialityService specialityService = new SpecialityService(connection);
        AddSpecialityService addSpecialityService = new AddSpecialityService(connection);

        mainContext = new MainContext(specialityService, addSpecialityService);

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/baseWindow.fxml"));
        Parent parent = fxmlLoader.load();

        BaseController baseController = fxmlLoader.getController();
        baseController.setContext(mainContext);

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.show();
    }
}
