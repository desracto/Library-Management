package com.example.assignment2fx2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 *  Authors: Mohammed Ejazzur(7305849) and Abdul Hadi (7330066)
 */

public class Library {

    ArrayList <Item> LibraryItems = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        Library temp = new Library(); // creating one object of library

        startProgram(temp);

    }

    public static void startProgram(Library temp) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to UOWD Library!");
        System.out.println("These are the current items within our library: ");

        int choice = 100; // so the program doesnt auto end
        while (choice != 0) {

            System.out.println("*******************LIBRARY********************");

            int index_display = 0;

            if(temp.LibraryItems.size() == 0) {
                System.out.println("There is nothing in the library!");
            }
            else
            {
                for(int i = 0; i < temp.LibraryItems.size(); i++) {
                    System.out.println("Index: " + index_display + " | " + temp.LibraryItems.get(i).displayItem()); // displaying index in arraylist alongside item data
                    index_display += 1;
                }
            }

            System.out.println("*******************LIBRARY********************");

            System.out.println("\n What would you like to do?");
            System.out.println("1. Add an item to the library \n" +
                    "2. Remove an item from the library \n" +
                    "3. Change information of an item in the library \n" +
                    "4. Display items in the library \n" +
                    "0. End Program");

            choice = in.nextInt(); // user input for menu

            switch (choice) { // running programs as per the user input
                case 1: {
                    // add selected
                    addItem(temp);
                    break;
                }
                case 2: {
                    // remove selected
                    try {
                        removeItem(temp);
                    } catch (Exception e) {
                        System.out.println(e + "\n");
                    }
                    break;
                }
                case 3: {
                    // change selected
                    try {
                        changeItem(temp);
                    } catch (Exception e) {
                        System.out.println(e + "\n");
                    }
                    break;
                }
                case 4: {
                    // display selected
                    try {
                        displayArray(temp);
                    } catch (Exception e) {
                        System.out.println(e + "\n");
                    }
                    break;
                }
            }// END OF SWITCH CASE
        }

    }// END OF START FUNCTION

    public static void addItem(Library temp) {
        // Adding an Item(type) to the arrayList

        System.out.println("What is the type of item you are adding?");
        System.out.println("1. Book \n" +
                "2. Journal \n" +
                "3. Media");

        Scanner in = new Scanner(System.in);
        int type_choice = 0;

        try { // try block to prevent accidental wrong input to crash program
            type_choice = in.nextInt(); // user input for the menu
        }
        catch (InputMismatchException e) {
            System.out.println("Wrong input"); // if wrong input
        }

        switch(type_choice) {

            case 1 : {
                // book selected
                System.out.println("Selected: Book");
                System.out.println("Please enter the Book Name, Author, Year of publication and ISBN");

                System.out.println("Book Name: ");
                String buffer = in.nextLine(); // buffer
                String item_name = in.nextLine();

                System.out.println("Author: ");
                String author = in.nextLine();

                System.out.println("Year of Publication");
                int year = in.nextInt();

                System.out.println("ISBN");
                int ISBN = in.nextInt();

                try {
                    Book book1 = new Book(item_name, author, year, ISBN); // creating a new book

                    temp.LibraryItems.add(book1); // adding book1 to variable

                    System.out.println("Added: " + book1.displayItem());
                    System.out.println("\n");

                } catch (Exception e) {
                    System.out.println("Error: " + e);
                }

                break;
            }// end of book

            case 2: {
                // journal selected
                System.out.println("Selected: Journal");
                System.out.println("Please enter the Journal name, Author, Year of Publication and Volume Number");

                System.out.println("Journal Name: ");
                String buffer = in.nextLine(); // buffer
                String item_name = in.nextLine();

                System.out.println("Author: ");
                String author = in.nextLine();

                System.out.println("Year of Publication");
                int year = in.nextInt();

                System.out.println("Volume Number");
                int vol_num = in.nextInt();

                try {
                    Journal j1 = new Journal (item_name, author, year, vol_num);

                    temp.LibraryItems.add(j1); // adding journal item to library arraylist

                    System.out.println("Added: " + j1.displayItem());
                }catch (Exception e){
                    System.out.println("Error: " + e);
                }

                break;
            }// end of journal

            case 3: {
                // media selected
                System.out.println("Selected: Media");
                System.out.println("Please enter the Media name, Author, Year of Publication and Type");

                System.out.println("Media Name: ");
                String buffer = in.nextLine(); // buffer
                String item_name = in.nextLine();

                System.out.println("Author: ");
                String author = in.nextLine();

                System.out.println("Year of Publication");
                int year = in.nextInt();

                System.out.println("Media Type");
                buffer = in.nextLine(); // buffer
                String type = in.nextLine();

                try {
                    Media m1 = new Media (item_name, author, year, type);

                    temp.LibraryItems.add(m1); // adding media item to library arraylist

                    System.out.println("Added: " + m1.displayItem());
                    System.out.println("**************************************");

                }catch (Exception e){
                    System.out.println("Error: " + e);
                }

                break;
            }// end of media
        }// END OF SWTICH CASE
    }// end of addItem();

    public static void removeItem(Library temp) throws Exception {

        if (temp.LibraryItems.size() == 0) {
            throw new Exception("There is nothing in the library");
        }
        else
        {
            Scanner in = new Scanner(System.in);

            System.out.println("What would you like to remove?");
            System.out.println("Index: ");

            int index = 100;

            try { // try catch block to account for wrong input of index
                index = in.nextInt();

                int choice = 5;
                while (choice != 2) {
                    System.out.println("Index Choosen: " + index);
                    System.out.println("Enter 1 to Confirm. Enter 2 to go back"); // choice to confirm deletion

                    choice = in.nextInt(); // user input for menu

                    switch(choice) {
                        case 1: {
                            // confirmed
                            System.out.println("Removing: " + temp.LibraryItems.get(index).displayItem());
                            temp.LibraryItems.remove(index);
                            choice = 2; // to prevent menu repetition
                            break;
                        }
                        case 2: {
                            // decides to go back to main menu
                            System.out.println("Going back...");
                            break;
                        }
                        default: {
                            // if wrong choice entered
                            System.out.println("INVALID CHOICE");
                            break;
                        }// end of default
                    }// end of switch
                }// end of while
            }// end of try

            catch(InputMismatchException e) {
                System.out.println("Wrong input");
            }
        }

    }// end of removeItem(int index, Library temp);

    public static void changeItem(Library temp) throws Exception {

        if (temp.LibraryItems.size() == 0) {
            throw new Exception ("There is nothing in the library.");
        }
        else
        {
            Scanner in = new Scanner(System.in);

            System.out.println("What do you want to change?");
            System.out.println("Index: ");
            int index = in.nextInt(); // user picks the index to change

            System.out.println("Index Selected: " + index);
            System.out.println("Selected: " + temp.LibraryItems.get(index).getName()); // showing what it is changing


            int choice = 20; // so it doesnt auto end
            while (choice != 0) {

                System.out.println("\n What do you want to change?");
                System.out.println("1. Name \n" +
                        "2. Author \n" +
                        "3. Year of Publication");

                // if block to repeat through classes to display their specific 4th var
                if (temp.LibraryItems.get(index) instanceof Book) {
                    System.out.println("4. ISBN \n");
                }
                else if (temp.LibraryItems.get(index) instanceof Journal) {
                    System.out.println("4. Journal Number \n");
                }
                else if (temp.LibraryItems.get(index) instanceof Media) {
                    System.out.println("4. Media Type");
                }

                System.out.println("0. Go back to menu"); // to end program

                choice = in.nextInt(); // asks user for choice

                switch (choice) {
                    case 1: {
                        // name selected
                        System.out.println("What is the new name?");
                        String buffer = in.nextLine(); // buffer
                        String new_name = in.nextLine();

                        System.out.println("Changing name of " + temp.LibraryItems.get(index).getName() + " to " + new_name);
                        temp.LibraryItems.get(index).setName(new_name);

                        System.out.println("\n");
                        System.out.println(temp.LibraryItems.get(index).displayItem());
                        break;
                    }// end of name

                    case 2: {
                        // Author selected
                        System.out.println("What is the new Author name?");
                        String buffer = in.nextLine(); // buffer

                        String new_author = in.nextLine();

                        System.out.println("Changing author of " + temp.LibraryItems.get(index).getAuthor() + " " + new_author);
                        temp.LibraryItems.get(index).setAuthor(new_author);

                        System.out.println("\n");
                        System.out.println(temp.LibraryItems.get(index).displayItem());

                        break;
                    }// end of author

                    case 3: {
                        // yob selected
                        System.out.println("What is the new year of publication?");
                        int year = in.nextInt();

                        System.out.println("Changing year of " + temp.LibraryItems.get(index).getName() + " to " + year);
                        temp.LibraryItems.get(index).setDate(year);


                        System.out.println("\n");
                        System.out.println(temp.LibraryItems.get(index).displayItem());
                        break;
                    }// end of yob

                    case 4: {
                        // 4th var selected

                        if (temp.LibraryItems.get(index) instanceof Book) { // looping through arraylist for only books
                            System.out.println("What is the new ISBN?");
                            int ISBN = in.nextInt(); // user input for new ISBN

                            Book b_temp = (Book) temp.LibraryItems.get(index);

                            System.out.println("Changing ISBN of " + temp.LibraryItems.get(index).getName() + " to " + ISBN);

                            b_temp.setISBN(ISBN);
                            temp.LibraryItems.set(index, b_temp);

                            System.out.println("\n");
                            System.out.println(temp.LibraryItems.get(index).displayItem());
                        }// end of book

                        else if (temp.LibraryItems.get(index) instanceof Journal) { // looping through arraylist for only journal
                            System.out.println("What is the new volume number?");
                            int new_vol_num = in.nextInt(); // user input for new volume number

                            Journal j_temp = (Journal) temp.LibraryItems.get(index);

                            System.out.println("Changing Volume Number of " + temp.LibraryItems.get(index).getName() + " to " + new_vol_num);

                            j_temp.setVol_num(new_vol_num);
                            temp.LibraryItems.set(index, j_temp);

                            System.out.println("\n");
                            System.out.println(temp.LibraryItems.get(index).displayItem());
                        }// end of journal

                        else if (temp.LibraryItems.get(index) instanceof Media) { // looping through arraylist for only media
                            System.out.println("What is the new Media Type?");
                            String buffer = in.nextLine(); // buffer
                            String new_type = in.nextLine(); // user input for new media type

                            Media m_temp = (Media) temp.LibraryItems.get(index);

                            System.out.println("Changing Media type of " + temp.LibraryItems.get(index).getName() + " to " + m_temp);

                            m_temp.setType(new_type);
                            temp.LibraryItems.set(index, m_temp);

                            System.out.println("\n");
                            System.out.println(temp.LibraryItems.get(index).displayItem());
                        }// end of media

                    }// end of case 4

                }// END OF SWITCH CASE
            }// END OF WHILE
        }

    }// END OF changeItem(Library temp);

    public static void displayArray(Library temp) throws Exception {

        if (temp.LibraryItems.size() == 0) {
            throw new Exception("There is nothing in the library");
        }
        else
        {
            Scanner in = new Scanner (System.in);

            System.out.println("What do you want to display?");
            System.out.println("1. Book \n" +
                    "2. Journal \n" +
                    "3. Media \n" +
                    "4. All \n" +
                    "0. Go back");

            int choice = in.nextInt();

            while (choice != 0) {

                switch (choice) {
                    case 1: {
                        // book selected
                        System.out.println("******************BOOKS*******************");
                        for(int i = 0; i < temp.LibraryItems.size(); i++)
                        {
                            if (temp.LibraryItems.get(i) instanceof Book)
                            {
                                System.out.println(temp.LibraryItems.get(i).displayItem());
                            }
                        }
                        System.out.println("******************BOOKS*******************");
                        choice = 0;
                        break;
                    }// end of book case

                    case 2: {
                        // journal selected
                        System.out.println("******************JOURNALS*******************");
                        for(int i = 0; i < temp.LibraryItems.size(); i++)
                        {
                            if (temp.LibraryItems.get(i) instanceof Journal)
                            {
                                System.out.println(temp.LibraryItems.get(i).displayItem());
                            }
                        }
                        System.out.println("******************JOURNALS*******************");
                        choice = 0;
                        break;
                    }// end of journal case

                    case 3: {
                        // media selected
                        System.out.println("******************MEDIA*******************");
                        for(int i = 0; i < temp.LibraryItems.size(); i++)
                        {
                            if (temp.LibraryItems.get(i) instanceof Media)
                            {
                                System.out.println(temp.LibraryItems.get(i).displayItem());
                            }
                        }
                        System.out.println("******************MEDIA*******************");
                        choice = 0;
                        break;
                    }// end of media case

                    case 4: {
                        // all selected
                        System.out.println("*******************LIBRARY********************");
                        for(int i = 0; i < temp.LibraryItems.size(); i++)
                        {
                            System.out.println(temp.LibraryItems.get(i).displayItem());
                        }
                        System.out.println("*******************LIBRARY********************");
                        choice = 0;
                        break;
                    }// end of all case
                    default: {
                        System.out.println("Going back...");
                    }
                }// END OF SWITCH
            }// END OF WHILE

        }

    }// END OF displayArray(Library temp)

}
