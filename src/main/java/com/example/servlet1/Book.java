package com.example.servlet1;

public class Book {
    private String name;
    private String author;
    private int date;
    private String genre;

    public Book(String name, String author, int date, String genre) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }


    public String getAuthor() {
        return author;
    }


    public int getDate() {
        return date;
    }


    public String getGenre() {
        return genre;
    }


}
