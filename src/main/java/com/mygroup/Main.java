package com.mygroup;

import com.mygroup.saveAndBases.DatabaseManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        DatabaseManager.initConnection();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/baseWindow.fxml"));
        Parent parent = fxmlLoader.load();
        Scene scene = new Scene(parent);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        DatabaseManager.closeConnection();
        super.stop();
    }
}

//@todo: Избавиться от хардкода (На позднее будущее)