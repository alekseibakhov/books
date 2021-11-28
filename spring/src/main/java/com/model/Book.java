package com.model;

public class Book {
    private int id;
    private String title;
    private String genre;
    private String author;
    private int date;
    private int numOfPages;

    public Book() {
    }

    public Book(int id, String title, String genre, String author, int date, int numOfPages) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.date = date;
        this.numOfPages = numOfPages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }
}
