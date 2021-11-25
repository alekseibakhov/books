package bd;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    private String title;
    private String author;
    private int date;
    private String genre;
    private int numOfPages;

    public Book() {

    }


    public Book(String title, String author, int date, String genre, int numOfPages) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.genre = genre;
        this.numOfPages = numOfPages;
    }

    public int getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString() {
        return id+" " + title + " " + author + " " + date + " " + genre + " " + numOfPages;
    }
}
