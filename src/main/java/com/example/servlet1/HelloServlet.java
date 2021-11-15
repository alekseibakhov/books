package com.example.servlet1;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletContext;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/")
public class HelloServlet extends HttpServlet {

    Book[] books = {
            new Book("Marsianin", "Endi Vier", 2011, "drama"),
            new Book("Cod Da-Vinci", "Den Braun", 2003, "detective"),
            new Book("The Minds of Billy Milligan", "Daniel Keyes", 1981, "novel")
    };

    ObjectMapper objectMapper = new ObjectMapper();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("books", objectMapper.writeValueAsString(books));

    }


}