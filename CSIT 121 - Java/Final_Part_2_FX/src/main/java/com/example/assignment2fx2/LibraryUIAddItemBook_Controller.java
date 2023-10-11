package com.example.assignment2fx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;

public class LibraryUIAddItemBook_Controller {

    public TextArea ISBN;
    public TextArea YOB;
    public AnchorPane rootPane;
    public TextArea BookName;
    public TextArea BookAuthor;
    public Text nameError;
    public Text authorError;
    public Text yearError;
    public Text isbnError;

    public void createBook(ActionEvent actionEvent) throws Exception {
        FileWriter writer = new FileWriter("Library.txt", true); // opening file writer

        if (BookName.getText() == "" || BookAuthor.getText() == "" || YOB.getText() == "" || ISBN.getText() == "" || Integer.parseInt(YOB.getText()) < 0 || Integer.parseInt(ISBN.getText()) < 0) { // if any are wrong
            // specifically finding out which is wrong
            if (BookName.getText() == "") { // name empty
                nameError.setOpacity(1);
            }
            if (BookAuthor.getText() == "") { // author empty
                authorError.setOpacity(1);
            }
            if (Integer.parseInt(YOB.getText()) <= 0) { // negative year
                yearError.setOpacity(1);
            }
            if (Integer.parseInt(ISBN.getText()) <= 0) { // negative isbn
                isbnError.setOpacity(1);
            }
        }
        else { // if no error
            // setting all error opacity to 0
            nameError.setOpacity(0);
            authorError.setOpacity(0);
            yearError.setOpacity(0);
            isbnError.setOpacity(0);

            String bookName = BookName.getText();
            String bookAuthor = BookAuthor.getText();
            int year = Integer.parseInt(YOB.getText());
            int bISBN = Integer.parseInt(ISBN.getText());

            Book b1 = null;
            try {
                b1 = new Book(bookName, bookAuthor, year, bISBN);

                writer.write("Book," + bookName + "," + bookAuthor + "," + year + "," + bISBN); // writing to file
                writer.write("\n"); // adding new line

                System.out.println("Successfully create book");
                System.out.println(b1.displayItem());
            }
            catch (Exception e) {
                System.out.println(e);
            }

            // clearing fields after submission
            BookName.clear();
            BookAuthor.clear();
            ISBN.clear();
            YOB.clear();

            writer.close(); // closing file writer
        }

    }

    // going back to add menu
    public void BackToAddMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUI_AddItem.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // go to LibraryUI_AddItem
        // this goes back to the Add Menu
        System.out.println("Going back to add menu");
    }


    // going back to main menu
    public void BackToMainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIMain.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // go to LibraryUIMain
        // this goes back to the main menu
        System.out.println("Going back to main menu");
    }
}
