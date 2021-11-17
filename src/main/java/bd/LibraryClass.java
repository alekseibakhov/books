package bd;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class LibraryClass {
    private static LibraryClass library;
    private List<Book> list;

    private LibraryClass() {
        createClass();
    }

    public static LibraryClass getClassLibrary() {
        if (library == null) return new LibraryClass();
        else return library;
    }

    private void createClass() {
        list = new CopyOnWriteArrayList<>();
        Book book1 = new Book("Marsianin", "Endi Vier", 2011, "drama");
        Book book2 = new Book("Cod Da-Vinci", "Den Braun", 2003, "detective");
        Book book3 = new Book("The Minds of Billy Milligan", "Daniel Keyes", 1981, "novel");
        list.add(book1);
        list.add(book2);
        list.add(book3);
    }


    public List<Book> getLibrary() {
        if (list == null) throw new ExceptionInInitializerError("класс не создан");
        return list;
    }


}
