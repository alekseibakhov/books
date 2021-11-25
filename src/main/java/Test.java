import bd.Book;
import dao.DAOImplLibrary;

public class Test {
    public static void main(String[] args) {
        DAOImplLibrary daoImplLibrary = new DAOImplLibrary();
        Book book = new Book("123", "1312", 123, "13123", 123);
//        daoImplLibrary.deleteBook(21);
//        daoImplLibrary.deleteBook(3);
//        daoImplLibrary.deleteBook(4);
//        daoImplLibrary.deleteBook(18);
//        daoImplLibrary.deleteBook(19);
//        daoImplLibrary.deleteBook(20);
        daoImplLibrary.addBook(book);

        }

    }

