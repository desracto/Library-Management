package com.example.assignment2fx2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UIMainController{
    
    public AnchorPane MainMenu; // root pane

    // moving to addItem menu
    public void loadAddItem(ActionEvent actionEvent) throws IOException { // COMPLETED

        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUI_AddItem.fxml")); // load FXML file
        MainMenu.getChildren().setAll((Node) fxmlLoader.load()); // sets the root pane (MainMenu)'s children to the children of the root pane of the add item fxml

        // look at LibraryUIAddItem Controller after this
        System.out.println("Loading LibraryUIAddItem Controller.....");
    }

    public void loadRemoveItem(ActionEvent actionEvent) throws IOException { // COMPLETED
        FXMLLoader fxmlLoader = new FXMLLoader((LibraryUIMain.class.getResource("LibraryUI_RemoveItem.fxml")));
        MainMenu.getChildren().setAll((Node) fxmlLoader.load());

        // look at LibraryUI_RemoveItem Controller after this
        System.out.println("Loading LibraryUI_RemoveItem Controller...");
    }

    public void loadChangeItem(ActionEvent actionEvent) throws IOException { // current
        FXMLLoader fxmlLoader = new FXMLLoader((LibraryUIMain.class.getResource("LibraryUI_ChangeItem.fxml")));
        MainMenu.getChildren().setAll((Node) fxmlLoader.load());

        // look at LibraryUI_ChangeItem Controller after this
        System.out.println("Loading LibraryUI_ChangeItem Controller...");

    }

    public void loadDisplay(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader((LibraryUIMain.class.getResource("LibraryUI_Display.fxml")));
        MainMenu.getChildren().setAll((Node) fxmlLoader.load());

        // look at LibraryUI_Display Controller after this
        System.out.println("Loading LibraryUI_Display Controller....");

    }
}
