package com.example.assignment2fx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;

public class LibraryUIAddItemMedia_Controller {


    public TextArea YOB;
    public TextArea MediaName;
    public TextArea MediaAuthor;
    public TextArea MediaType;
    public Text nameError;
    public Text authorError;
    public Text yearError;
    public Text mediaTypeError;
    public AnchorPane rootPane;

    public void createMedia(ActionEvent actionEvent) throws IOException {
        FileWriter writer = new FileWriter("Library.txt", true);

        if (MediaName.getText() == "" || MediaAuthor.getText() == "" || YOB.getText() == "" || MediaType.getText() == "" ) {
            if (MediaName.getText() == "") {
                nameError.setOpacity(1);
            }
            if (MediaAuthor.getText() == "") {
                authorError.setOpacity(1);
            }
            if (YOB.getText() == "") {
                yearError.setOpacity(1);
            }
            if (MediaType.getText() == "") {
                mediaTypeError.setOpacity(1);
            }
        }
        else {
            // setting error opacity to 0
            nameError.setOpacity(0);
            authorError.setOpacity(0);
            yearError.setOpacity(0);
            mediaTypeError.setOpacity(0);

            String MName = MediaName.getText();
            String MAuthor = MediaAuthor.getText();
            int year = Integer.parseInt(YOB.getText());
            String MType = MediaType.getText();

            Media m1 = null;
            try {
                m1 = new Media(MName, MAuthor, year, MType);

                writer.write("Media," + MName + "," + MAuthor + "," + year + "," + MType);
                writer.write("\n");

                System.out.println("Sucessfully created media");
                System.out.println(m1.displayItem());
            }
            catch (Exception e) {
                System.out.println(e);
            }

            // clearing fields
            MediaName.clear();
            MediaAuthor.clear();
            YOB.clear();
            MediaType.clear();

            // closing writer
            writer.flush();
            writer.close();

        }

    }

    public void BackToAddMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUI_AddItem.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // going back to Add menu
        System.out.println("Going back to add menu");
    }

    public void BackToMainMenu(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LibraryUIMain.class.getResource("LibraryUIMain.fxml"));
        rootPane.getChildren().setAll((Node) fxmlLoader.load());

        // going back to main menu
        System.out.println("Going back to main menu");
    }
}
