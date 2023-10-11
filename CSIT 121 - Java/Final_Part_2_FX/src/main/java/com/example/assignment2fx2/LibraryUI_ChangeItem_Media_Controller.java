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

public class LibraryUI_ChangeItem_Media_Controller {
    public AnchorPane rootPane;
    public TextField name;
    public TextField author;
    public TextField year;
    public TextField media_type;
    private int index;

    public void grabItemDetails(String name, String author, int year, String type, int index) {
        // autofill text fields to existing information
        // for user ease

        this.name.setText(name);
        this.author.setText(author);
        this.year.setText(String.valueOf(year));
        this.media_type.setText(type);
        this.index = index;
    }

    // fxml func
    public void confirmChange(ActionEvent actionEvent) throws Exception {
        // func on casting item change
        // updates text file

        if (name.getText().trim() == "" || author.getText().trim() == "" || year.getText().trim() == "" || media_type.getText().trim() == "") {
            System.out.println("Invalid Entry!");
        }
        else {
            // grabbing user input
            String name = this.name.getText();
            String author = this.author.getText();
            int year = Integer.parseInt(this.year.getText());
            String m_type = this.media_type.getText();

            // updating and rewriting file
            updateFile(importFile(), name, author, year, m_type, index);
        }
    }

    public static ArrayList<Item> importFile() throws Exception {
        // imports txt file to an arraylist
        // converts to Item arraylist

        Scanner reader = new Scanner(new File("Library.txt"));

        ArrayList<String> librarytxt = new ArrayList<>(); // arraylist to hold library.txt
        ArrayList<Item> library = new ArrayList<>(); // converted arraylist to item

        while(reader.hasNextLine()) {
            librarytxt.add(reader.nextLine());
        }

        for (String s : librarytxt) {
            String [] temp = s.split(",");

            // common variables
            String type = temp[0];
            String name = temp[1];
            String author = temp[2];
            int year = Integer.parseInt(temp[3]);

            // creating item with unique 4th var
            switch(type) {
                case("Book") -> {
                    library.add(new Book(name, author, year, Integer.parseInt(temp[4])));
                }
                case("Journal") -> {
                    library.add(new Journal(name, author, year, Integer.parseInt(temp[4])));
                }
                case("Media") -> {
                    library.add(new Media(name, author, year, temp[4]));
                }
            }// end switch
        }// end of for - converting string to item arraylist

        reader.close();
        return library;
    }

    public void updateFile(ArrayList<Item> library, String name, String author, int year, String type, int index) throws IOException {
        // changing library arraylist based on index
        // updating text file

        //changing item info based on index
        library.get(index).setName(name);
        library.get(index).setAuthor(author);
        library.get(index).setDate(year);
        ((Media) library.get(index)).setType(type);

        // updating file
        FileWriter writer = new FileWriter("Library.txt");

        for(Item it : library) {
            if(it instanceof Book) {
                writer.write("Book," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Book) it).getISBN());
                writer.write("\n");
            }
            else if (it instanceof Journal) {
                writer.write("Journal," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Journal) it).getVol_num());
                writer.write("\n");
            }
            else if (it instanceof Media) {
                writer.write("Media," + it.getName() + "," + it.getAuthor() + "," + it.getDate().getYear() + "," + ((Media) it).getType());
                writer.write("\n");
            }
        }// end of for - rewriting amd updating file
        writer.flush();
        writer.close();
    }


    public void BackToViewMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_ChangeItem.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }
}
