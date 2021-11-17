package com.example.servlet1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import bd.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DAO;
import dao.DAOImplLibrary;

@WebServlet("/saveservlet")
public class SaveServlet extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    DAO dao = new DAOImplLibrary();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> library = dao.getBook();
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("books", objectMapper.writeValueAsString(library));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/libraryServlet");
        dispatcher.forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        int date = Integer.parseInt(req.getParameter("date"));
        String genre = req.getParameter("genre");
        dao.addBook(new Book(name, author, date, genre));

        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("books", objectMapper.writeValueAsString(dao.getBook()));


        resp.getWriter().write(req.getServletContext().getAttribute("books").toString());
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dao.deleteBook(id);
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("books", objectMapper.writeValueAsString(dao.getBook()));
        resp.getWriter().write(req.getServletContext().getAttribute("books").toString());
    }
}
