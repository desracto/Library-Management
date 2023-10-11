package com.example.assignment2fx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LibraryUIAddItem {

    public AnchorPane rootPane;

    public void addBook(ActionEvent actionEvent) throws IOException { // book selected
        System.out.println("addBook selected");

        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIADDItem_Book.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // go to LibraryUIAddItemBook_Controller
    }

    public void addMedia(ActionEvent actionEvent) throws IOException { // media selected
        System.out.println("addMedia selected");

        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUI_AddItem_Media.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // go to LibraryUI_AddItem_Media_Controller
    }

    public void addJournal(ActionEvent actionEvent) throws IOException { // journal selected
        System.out.println("addJournal selected");

        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUI_AddItem_Journal.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // go to LibraryUI_AddItem_Journal_Controller
    }

    public void goBacktoMainMenu(ActionEvent actionEvent) throws IOException { // back to main menu
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIMain.fxml")); // load main menu file
        rootPane.getChildren().setAll((Node) fxmlLoader.load()); // setting root pane to main menu

        // go to UIMainController
        System.out.println("Loading UIMainController...");
        System.out.println("Going back to main menu...");
    }
}
