package com.example.assignment2fx2;

public class Book extends Item{

    private int ISBN;

    //para const
    // parent class: string name, string author, int year, int month, int day
    public Book(String name, String author, int year, int ISBN) throws Exception {
        super(name, author, year);

        if (ISBN <= 0) {
            throw new Exception("Invalid ISBN");
        }
        this.ISBN = ISBN;
    }

    //setter and getter
    public int getISBN() {
        return ISBN;
    }
    public void setISBN(int iSBN) {
        ISBN = iSBN;
    }

    @Override
    public String displayItem() {
        // display function polymorphed to fit book item
        String str = "Book Name: " + super.getName() +
                     "| Author Name: " + super.getAuthor() +
                     "| Year of Publication: " + super.getDate().getYear() +
                     "| ISBN: " + getISBN();
        return str;
    }

    public String toString() {
        return  "Book Name: " + super.getName() +
                "| Author Name: " + super.getAuthor() +
                "| Year of Publication: " + super.getDate().getYear() +
                "| ISBN: " + getISBN();
    }



}
