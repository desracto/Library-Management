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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryUIChangeItem_Controller {

    public AnchorPane rootPane;
    public ListView LibraryViewPane;
    private ObservableList<Item> list = FXCollections.observableArrayList();

    // run on start
    public void initialize() throws Exception {
        LibraryViewPane.setItems(list);
        list.addAll(initList());
    }

    // fxml function
    public void changeItem(ActionEvent actionEvent) throws IOException {
        int index = LibraryViewPane.getSelectionModel().getSelectedIndex();

        Item it = list.get(index); // getting item selected by user

            if (it instanceof Book) {
                FXMLLoader loader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIChangeItem_Book.fxml")); // loading book change
                rootPane.getChildren().setAll((Node) loader.load()); // changing ui to change book

                LibraryUIChangeItem_Book_Controller book_cont = loader.getController(); // create controller instance
                book_cont.grabItemDetails(it.getName(), it.getAuthor(), it.getDate().getYear(), ((Book) it).getISBN(), index); // passing item book details to the change book controller
            }
            else if (it instanceof Journal) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_ChangeItem_Journal.fxml")); // loading journal change fxml
                rootPane.getChildren().setAll((Node) loader.load()); // changing ui to change journal

                LibraryUI_ChangeItem_Journal_Controller journalSender = loader.getController();
                journalSender.grabItemDetails(it.getName(), it.getAuthor(), it.getDate().getYear(), ((Journal) it).getVol_num(), index); // passing item book details to the change journal controller
            }
            else if (it instanceof Media) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_ChangeItem_Media.fxml"));
                rootPane.getChildren().setAll((Node) loader.load()); // changing view to change media

                LibraryUI_ChangeItem_Media_Controller temp = loader.getController();
                temp.grabItemDetails(it.getName(), it.getAuthor(), it.getDate().getYear(), ((Media) it).getType(), index);

            }
    }

    // non-fx func
    public ArrayList<Item> initList() throws Exception {
        Scanner reader = new Scanner(new File("Library.txt"));

        ArrayList<String> temp = new ArrayList<>(); // opening temp string list
        ArrayList<Item> lib_list = new ArrayList<>();

        while(reader.hasNextLine()) {
            temp.add(reader.nextLine()); // populating list
        }

        for (String s : temp) {
            String [] item_holder = s.split(",");

            String type = item_holder[0]; // reading type
            String name = item_holder[1];
            String author = item_holder[2];
            int year = Integer.parseInt(item_holder[3]);

            switch (type) {
                case("Book") -> {
                    int ISBN = Integer.parseInt(item_holder[4]);
                    lib_list.add(new Book(name, author, year, ISBN));
                }
                case("Journal") -> {
                    int j_num = Integer.parseInt(item_holder[4]);
                    lib_list.add(new Journal(name, author, year, j_num));
                }
                case("Media") -> {
                    String m_type = item_holder[4];
                    lib_list.add(new Media(name, author, year, m_type));
                }
            }// end of switch
        }
        return lib_list;
    }

    public void BackToViewMenu(ActionEvent actionEvent) throws IOException {
        // going back to main menu

        FXMLLoader loader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIMain.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }

}
