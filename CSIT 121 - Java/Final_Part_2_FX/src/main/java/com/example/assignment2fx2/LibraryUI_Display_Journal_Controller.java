package com.example.assignment2fx2;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryUI_Display_Journal_Controller {
    public AnchorPane rootPane;
    public ListView DisplayFilterPane;
    public ObservableList<Item> list = FXCollections.observableArrayList();

    public void initialize() throws Exception {
        DisplayFilterPane.setItems(list);

        list.addAll(filter("Journal", importFile()));
    }

    public ArrayList<Item> importFile() throws Exception {
        Scanner reader = new Scanner(new File("Library.txt"));

        ArrayList<String> librarytxt = new ArrayList<>();
        ArrayList<Item> library = new ArrayList<>();

        while(reader.hasNextLine()) {
            librarytxt.add(reader.nextLine()); // temp holdiing all items in text file
        }

        for (String s : librarytxt) {
            String [] temp = s.split(","); // storing line by line in temp static array

            String type = temp[0];
            String name = temp[1];
            String author = temp[2];
            int year = Integer.parseInt(temp[3]);

            switch (type) {
                case("Book") -> {
                    library.add(new Book(name, author, year, Integer.parseInt(temp[4])));
                }
                case("Journal") -> {
                    library.add(new Journal(name, author, year, Integer.parseInt(temp[4])));
                }
                case("Media") -> {
                    library.add(new Media(name, author, year, temp[4]));
                }
            } // end of switch
        }// end of for
        return library;
    }

    public ArrayList<Item> filter(String type, ArrayList<Item> library) {
        // returns filtered arraylist based on user input

        ArrayList<Item> filtered = new ArrayList<>();

        for (Item it : library) {
            switch(type) {
                case("Book") -> {
                    if (it instanceof Book) {
                        filtered.add(it);
                    }
                }
                case("Journal") -> {
                    if (it instanceof Journal) {
                        filtered.add(it);
                    }
                }
                case("Media") -> {
                    if (it instanceof Media) {
                        filtered.add(it);
                    }
                }
            }
        }
        return filtered;
    }

    public void goBack(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_Display.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }
}
