package com.example.servlet1;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import bd.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dao.DAO;
import dao.DAOImplLibrary;

@WebServlet("/saveservlet")
public class SaveServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    DAO dao = new DAOImplLibrary();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        List<Book> library = dao.getBook();
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("books", objectMapper.writeValueAsString(library));
        resp.getWriter().write(req.getServletContext().getAttribute("books").toString());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        StringBuilder jb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
        Book book = new Gson().fromJson(String.valueOf(jb), Book.class);
        dao.addBook(book);
        req.getServletContext().setAttribute("books", objectMapper.writeValueAsString(dao.getBook()));

    }


    //гет здесь получает значения по url, а не в теле запроса
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String name = req.getParameter("name");
//        String author = req.getParameter("author");
//        int date = Integer.parseInt(req.getParameter("date"));
//        String genre = req.getParameter("genre");
//        dao.addBook(new Book(name, author, date, genre));
//        ServletContext servletContext = req.getServletContext();
//        servletContext.setAttribute("books", objectMapper.writeValueAsString(dao.getBook()));
//        resp.getWriter().write(req.getServletContext().getAttribute("books").toString());
//    }
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        int id = Integer.parseInt(req.getParameter("id"));
//        dao.deleteBook(id);
//        ServletContext servletContext = req.getServletContext();
//        servletContext.setAttribute("books", objectMapper.writeValueAsString(dao.getBook()));
//        resp.getWriter().write(req.getServletContext().getAttribute("books").toString());
//    }
}
