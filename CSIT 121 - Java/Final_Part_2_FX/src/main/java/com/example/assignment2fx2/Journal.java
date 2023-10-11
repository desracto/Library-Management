package com.example.assignment2fx2;

public class Journal extends Item {

    private int vol_num;

    //para const
    // parent class: string name, string author, int year, int month, int day
    public Journal(String name, String author, int year, int vol_num) throws Exception {
        super(name, author, year);

        if (vol_num <= 0) {
            throw new Exception("Invalid volume number");
        }
        this.vol_num = vol_num;
    }

    // setter and getter
    public int getVol_num() {
        return vol_num;
    }
    public void setVol_num(int vol_num) {
        this.vol_num = vol_num;
    }


    @Override
    public String displayItem() {
        //display function polymorphed to journal class
        String str = "Journal Name: " + super.getName() +
                "| Journal's Author: " + super.getAuthor() +
                "| Year of Publication: " + super.getDate().getYear() +
                "| Volumne Number: " + getVol_num();
        return str;
    }

    public String toString() {
        return  "Journal Name: " + super.getName() +
                "| Journal's Author: " + super.getAuthor() +
                "| Year of Publication: " + super.getDate().getYear() +
                "| Volume Number: " + getVol_num();
    }




}
