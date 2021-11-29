package com.controller;

import com.dao.BookDAO;
import com.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/library")
public class MyController {
    private final BookDAO bookDAO;

    public MyController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String getLibrary(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("library", bookDAO.getLibrary());
        return "library";
    }

    @GetMapping("/{index}")
    public String getBookById(@PathVariable("index") int id, Model model) {
        model.addAttribute("book", bookDAO.getBookById(id));
        return "book";
    }


    @PostMapping
    public String createBook(@ModelAttribute("newBook") Book book) {
        bookDAO.createBook(book);
        return "redirect:/library";
    }

    @DeleteMapping("/{index}")
    public String deleteBook(@PathVariable("index") int index) {
        bookDAO.delete(index);
        return "redirect:/library";
    }
}
