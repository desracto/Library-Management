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

public class LibraryUI_ChangeItem_Journal_Controller {

    public AnchorPane rootPane;
    public TextField name;
    public TextField author;
    public TextField year;
    public TextField journal_number;
    private int index;

    public void grabItemDetails(String name, String author, int year, int j_num, int index) {
        // grabbing variables from main controller
        // auto fills text fields to the existing data of the item selected
        this.name.setText(name);
        this.author.setText(author);
        this.year.setText(String.valueOf(year));
        this.journal_number.setText(String.valueOf(j_num));
        this.index = index;
    }

    // fxml
    public void confirmChange(ActionEvent actionEvent) throws Exception {
        // grabbing user input

        if (name.getText().trim() == "" || author.getText().trim() == "" || year.getText().trim() == "" || journal_number.getText().trim() == "") {
            throw new Exception("Invalid Entry!");
        }
        else
        {
            String name = this.name.getText();
            String author = this.author.getText();
            int year = Integer.parseInt(this.year.getText());
            int j_num = Integer.parseInt(this.journal_number.getText());

            // updating file with new changes
            updateFile(importFile(), name, author, year, j_num, index);
        }
    }

    public static ArrayList<Item> importFile() throws Exception {
        // imports the library txt file into the code
        // returns arraylist
        Scanner reader = new Scanner(new File("Library.txt"));

        ArrayList<String> librarytxt = new ArrayList<>(); // storing text file in arraylist
        ArrayList<Item> library = new ArrayList<>();

        while(reader.hasNextLine()) {
            librarytxt.add(reader.nextLine()); // reading each line and storing into string arraylist
        }

        for(String s : librarytxt) {
            String [] temp = s.split(",");

            String type = temp[0]; // type of Item
            String name = temp[1]; // name
            String author = temp[2]; // author
            int year = Integer.parseInt(temp[3]); // year

            switch(type) {
                case("Book") -> {
                    int ISBN = Integer.parseInt(temp[4]);
                    library.add(new Book(name, author, year, ISBN));
                }
                case("Journal") -> {
                    int j_num = Integer.parseInt(temp[4]);
                    library.add(new Journal(name, author, year, j_num));
                }
                case("Media") -> {
                    String m_type = temp[4];
                    library.add(new Media(name, author, year, m_type));
                }
            }// end of switch
        }// end of for
        return library;
    }

    public static void updateFile(ArrayList<Item> library, String name, String author, int year, int j_num, int index) throws IOException {
        // accepts arraylist and item args and index
        // rewrites the file for update

        // updating arraylist based on user selected index
        library.get(index).setName(name);
        library.get(index).setAuthor(author);
        library.get(index).setDate(year);
        ((Journal) library.get(index)).setVol_num(j_num);

        // updating file
        FileWriter writer = new FileWriter("Library.txt");

        for (Item it : library) {
            if (it instanceof Book) {
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
        }// end of for
        writer.flush();
        writer.close();
    }

    // fxml
    public void BackToViewMenu(ActionEvent actionEvent) throws IOException {
        // goes back to change item ui

        FXMLLoader loader = new FXMLLoader(getClass().getResource("LibraryUI_ChangeItem.fxml"));
        rootPane.getChildren().setAll((Node) loader.load());
    }


}
