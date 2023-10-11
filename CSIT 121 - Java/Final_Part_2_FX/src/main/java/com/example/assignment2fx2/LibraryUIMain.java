package com.example.assignment2fx2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryUIMain extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIMain.fxml")); // load FXML file
        Scene scene = new Scene(fxmlLoader.load()); // setup scene using FXML
        stage.setTitle("UOWD Library");
        stage.setScene(scene);

        stage.show(); // start the show
    }
}
