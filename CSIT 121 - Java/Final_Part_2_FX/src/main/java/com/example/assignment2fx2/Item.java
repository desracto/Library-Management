package com.example.assignment2fx2;

import java.util.Date;

/*
 * Abstract Class Item. Cannot be initialized into its own object.
 * Has to be initialized as either of the three children classes:
 * Book / Journal / Media
 * Author: Mohammed Ejazzur (7305849) and Abdul Hadi (7330066)
 */

public abstract class Item implements ItemInterface { // parent class of book, journal, media

    private String name;
    private String author;
    private Date dateOfPublication;

    //para const
    // parent class: string name, string author, int year, int month, int day
    public Item(String name, String author, int year) throws Exception {
        // exception block
        if (name == "" || name.trim() == "") {
            throw new Exception("Invalid Name"); // if item name is empty
        }
        if (author == " " || author.trim() == "") {
            throw new Exception("Invalid Author Name"); // if author name is empty
        }
        if (year <= 0) {
            throw new Exception("Invalid date"); // if date is wrong
        }

        this.name = name;
        this.author = author;
        this.dateOfPublication = new Date(year, 1, 1);

    }

    // get block
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return dateOfPublication;
    }

    // set block

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(int year) {
        this.dateOfPublication = new Date(year, 1, 1);
    }

}// end of ITEM