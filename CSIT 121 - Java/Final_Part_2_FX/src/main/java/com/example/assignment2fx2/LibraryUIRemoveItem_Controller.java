package com.example.assignment2fx2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryUIRemoveItem_Controller {

    public AnchorPane rootPane;
    public ListView LibraryViewPane;
    private ObservableList<Item> list = FXCollections.observableArrayList();
    private ArrayList<Item> update_list;

    public void initialize() throws Exception { // runs on start
        LibraryViewPane.setItems(list);
        ArrayList<Item> lib_list = initList(); // populating arraylist

        // populating ObservableList using lib_list
        list.addAll(lib_list);


    }

    public void removeItem(ActionEvent actionEvent) throws IOException {
        // removing an item from list view
        int index = LibraryViewPane.getSelectionModel().getSelectedIndex(); // gets the selected index
        System.out.println("Index selected: " + index);
        list.remove(index);

        // update file block
        FileWriter writer = new FileWriter("Library.txt");
        for (Item it : list) {
            if (it instanceof Book) {
                writer.write("Book," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Book) it).getISBN());
                writer.write("\n");
            }
            else if (it instanceof Journal) {
                writer.write("Journal," +it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Journal) it).getVol_num());
                writer.write("\n");
            }
            else if (it instanceof Media) {
                writer.write("Media," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Media) it).getType());
                writer.write("\n");
            }
        }
        writer.flush();
        writer.close();
    }

    public void BackToMainMenu(ActionEvent actionEvent) throws IOException {
        // returning to main menu

        FXMLLoader loader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIMain.fxml")); // loading Main Menu fxml
        rootPane.getChildren().setAll((Node) loader.load()); // changing root to Main Menu

        System.out.println("Moving from Remove Item to Main Menu");
    }

    private static ArrayList<Item> initList() throws Exception {
        Scanner reader = new Scanner(new File("Library.txt"));

        ArrayList<String> librarytxt = new ArrayList<>(); // opening string arraylist to read file
        ArrayList<Item> library_list = new ArrayList<>(); // arraylist to be returned

        while (reader.hasNext()) {
            librarytxt.add(reader.nextLine()); // populating temp arraylist
        }

        for (String s : librarytxt) {
            String[] temp = s.split(","); // reading librarytxt line into String array

            String type = temp[0]; // reading type of item
            String name = temp[1]; // reading name of the item
            String author = temp[2]; // reading author of the item
            int year = Integer.parseInt(temp[3]); // reading year of the item

            switch (type) {
                case ("Book") -> {
                    int ISBN = Integer.parseInt(temp[4]); // reading 4th var specific to item type
                    library_list.add(new Book(name, author, year, ISBN)); // adding to list
                }
                case ("Journal") -> {
                    int j_num = Integer.parseInt(temp[4]); // reading 4th var specific to item type
                    library_list.add(new Journal(name, author, year, j_num)); // adding to list
                }
                case ("Media") -> {
                    String m_type = temp[4]; // reading 4th var specific to item type
                    library_list.add(new Media(name, author, year, m_type)); // adding to list
                }
                default -> {
                    System.out.println("ERROR: WRONG TYPE");
                }
            }// end of switch case
        }// end of for
        return library_list;
    }
}
