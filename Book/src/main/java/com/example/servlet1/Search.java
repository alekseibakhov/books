package com.example.servlet1;

import bd.Book;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.DAO;
import dao.DAOImplLibrary;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "search", value = "/search")
public class Search extends HttpServlet {
    ObjectMapper objectMapper = new ObjectMapper();
    DAO dao = new DAOImplLibrary();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletContext servletContext = request.getServletContext();
        int id = Integer.parseInt(request.getParameter("id"));
        servletContext.setAttribute("book", objectMapper.writeValueAsString(dao.getBookById(id)));
//        response.getWriter().write(request.getServletContext().getAttribute("book").toString());
        Book book = dao.getBookById(id);
        PrintWriter writer = response.getWriter(); //
        writer.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Book</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n" +
                "          integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n" +
                "    <link href=\"books.css\" rel=\"stylesheet\">\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"book_base\">\n" +
                "\n" +
                        "<div class=\"card\" style=\"width: 18rem; flex-direction: row\">\n" +
                        "    <img src=\"img/library.jpg\" class=\"card-img-top\" style=\"\" alt=\"Book\">\n" +
                        "    <div class=\"card-body\" >\n" +
                        "        <h5 class=\"card-title\" style=\"width: 400px\">"+ book.getTitle()+ "</h5>\n" +
                        "        <ul class=\"card-text\">\n" +
                        "            <li>"+ book.getAuthor()+"</li>\n" +
                        "            <li>"+ book.getGenre()+ "</li>\n" +
                        "            <li>"+ book.getDate()+ "</li>\n" +
                        "            <li>"+ book.getNumOfPages()+ "</li>\n" +
                        "        </ul>\n" +
                        "        <a href=\"http://localhost:8080/library\" class=\"btn btn-primary\" style=\"margin-top: 150px\">back</a>\n" +
                        "\n" +
                        "    </div>\n" +
                        "</div>" +
                "</div>\n" +
                "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\"\n" +
                "        integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\"\n" +
                "        crossorigin=\"anonymous\"></script>\n" +
                "<script src=\"book1.js\"></script>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuilder jb = new StringBuilder();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
        String idStr = jb.toString();
        int id = Integer.parseInt(idStr);
        dao.deleteBook(id);
        req.getServletContext().setAttribute("books", objectMapper.writeValueAsString(dao.getBook()));
    }
}