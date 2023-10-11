package com.example.assignment2fx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryUIChangeItem_Book_Controller {

    public TextField ISBN;
    public AnchorPane rootPane;
    public TextField name;
    public TextField author;
    public TextField year;
    public int index;

    public void grabItemDetails(String name, String author, int year, int ISBN, int index) {
        // grabbing information from main change item controller
        this.name.setText(name);
        this.author.setText(author);
        this.year.setText(String.valueOf(year));
        this.ISBN.setText(String.valueOf(ISBN));
        this.index = index;
    }

    public void confirmChange(ActionEvent actionEvent) throws Exception {
        System.out.println("Changing item information");

        if (name.getText().trim() == "" || author.getText().trim() == "" || year.getText().trim() == "" || ISBN.getText().trim() == "") {
            throw new Exception("Invalid entry!");
        }
        else {
            // grabs user info
            String name = this.name.getText();
            String author = this.author.getText();
            int year = Integer.parseInt(this.year.getText());
            int ISBN = Integer.parseInt(this.ISBN.getText());

            // updates file
            updateFile(importFile(), name, author, year, ISBN, this.index);
        }
    }

    public ArrayList<Item> importFile() throws Exception {
        // imports library.txt into the controller
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
    }// end of import

    public static void updateFile(ArrayList<Item> library, String name, String author, int year, int ISBN, int index) throws IOException {
        FileWriter writer = new FileWriter("Library.txt");

        // updating specific entry based on user selection
        library.get(index).setName(name);
        library.get(index).setAuthor(author);
        library.get(index).setDate(year);
        ((Book) library.get(index)).setISBN(ISBN);

        // rewriting file
        for(Item it : library) {
            if (it instanceof Book) {
                writer.write("Book," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Book) it).getISBN());
                writer.write("\n");
            }
            if (it instanceof Journal) {
                writer.write("Journal," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Journal) it).getVol_num());
                writer.write("\n");
            }
            if (it instanceof Media) {
                writer.write("Media," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Media) it).getType());
                writer.write("\n");
            }
        }// end of for
        writer.flush();
        writer.close();
    }// end of update

    public void BackToViewMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_ChangeItem.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }

}
