package com.example.servlet1;

import bd.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DAO;
import dao.DAOImplLibrary;

import javax.servlet.ServletContext;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "search", value = "/search")
public class Search extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    DAO dao = new DAOImplLibrary();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        int id = Integer.parseInt(request.getParameter("id"));
        dao.getBookById(id);
        response.getWriter().write(dao.getBookById(id).toString());
//        servletContext.setAttribute("books", objectMapper.writeValueAsString(books));

    }


}