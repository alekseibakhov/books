package bd;

public class Book {
    private String name;
    private String author;
    private int date;
    private String genre;
    private int numOfPages;


    public Book(String name, String author, int date, String genre, int numOfPages) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.genre = genre;
        this.numOfPages = numOfPages;
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

    public int getNumOfPages() { return numOfPages; }


    @Override
    public String toString() {
        return name + " " + author + " " + date + " " + genre + " " + numOfPages;
    }
}
