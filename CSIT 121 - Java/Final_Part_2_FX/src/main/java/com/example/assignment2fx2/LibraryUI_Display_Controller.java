package com.example.assignment2fx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryUI_Display_Controller {
    public AnchorPane rootPane;

    public void displayBook(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_Display_Book.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());

    }

    public void displayMedia(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_Display_Media.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }

    public void displayJournal(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_Display_Journal.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());

    }

    public void displayAll(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_Display_All.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }

    public void goBacktoMainMenu(ActionEvent actionEvent) throws IOException {
        // going back to main menu

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUIMain.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }


}
