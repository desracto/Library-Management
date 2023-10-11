package com.example.assignment2fx2;

public class Media extends Item {

    private String type;

    //para const
    // parent class: string name, string author, int year
    public Media (String name, String author, int year, String type) throws Exception{
        super(name, author, year);

        if (type == "" || type.trim() == "") {
            throw new Exception("Invalid Media Type");
        }
        this.type = type;
    }

    // getter and setter
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String displayItem() {
        // display function polymorphed to Media
        String str = "Media Type: " + getType() +
                "| Media Name: " + super.getName() +
                "| Media Author: " + super.getAuthor() +
                "| Year of Publication " + super.getDate().getYear();
        return str;
    }

    public String toString() {
        return  "Media Type: " + getType() +
                "| Media Name: " + super.getName() +
                "| Media Author: " + super.getAuthor() +
                "| Year of Publication " + super.getDate().getYear() +
                "| Media Type: " + getType();
    }



}
