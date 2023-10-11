package com.example.assignment2fx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;

public class LibraryUIAddItemJournal_Controller {

    public TextArea YOB;
    public AnchorPane rootPane;
    public TextArea JournalName;
    public TextArea JournalAuthor;
    public Text nameError;
    public Text authorError;
    public Text yearError;
    public TextArea JournalNumber;
    public Text jnError;

    public void createJournal(ActionEvent actionEvent) throws Exception {
        FileWriter writer = new FileWriter("Library.txt", true); // opening file writer

        if (JournalName.getText() == "" || JournalAuthor.getText() == "" || YOB.getText() == "" || JournalNumber.getText() == "") {
            if (JournalName.getText() == "") {
                nameError.setOpacity(1);
            }
            if (JournalAuthor.getText() == "") {
                authorError.setOpacity(1);
            }
            if (Integer.parseInt(YOB.getText()) <= 0) {
                yearError.setOpacity(1);
            }
            if (Integer.parseInt(JournalNumber.getText()) <= 0) {
                jnError.setOpacity(1);
            }
        }
        else { // if no error

            // setting errors to 0 to
            nameError.setOpacity(0);
            authorError.setOpacity(0);
            yearError.setOpacity(0);
            jnError.setOpacity(0);

            String journalName = JournalName.getText();
            String journalAuthor = JournalAuthor.getText();
            int year = Integer.parseInt(YOB.getText());
            int journalNumber = Integer.parseInt(JournalNumber.getText());

            Journal j1 = null;
            try {
                j1 = new Journal(journalName, journalAuthor, year, journalNumber);

                writer.write("Journal," + journalName + "," + journalAuthor + "," + year + "," + journalNumber);
                writer.write("\n");

                System.out.println("Successfully created Journal");
                System.out.println(j1.displayItem());
            }
            catch (Exception e) {
                System.out.println(e);
            }

            // closing writer
            writer.flush();
            writer.close();

            // clearing fields
            JournalName.clear();
            JournalAuthor.clear();
            YOB.clear();
            JournalNumber.clear();
        }
    }


    public void BackToAddMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUI_AddItem.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // go to LibraryUI_AddItem
        // this goes back to the main menu
        System.out.println("Going back to add menu");
    }

    public void BackToMainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIMain.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // go to LibraryUIMain
        // goes back to main menu
        System.out.println("Goign back to main menu");
    }


}
