import bd.Book;
import bd.ConnectionJDBC;
import dao.DAO;
import dao.DAOImplLibrary;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException {
        DAO dao = new DAOImplLibrary();
        System.out.println(dao.getBookById(46));

    }

}

