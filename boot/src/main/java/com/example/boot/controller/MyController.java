package com.example.boot.controller;

import com.example.boot.model.Book;
import com.example.boot.repository.LibraryRepository;
import com.example.boot.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library")
public class MyController {
    private final LibraryService libraryService;

    @Autowired
    public MyController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('developers:read')")
    public String getAll(Model model) {
        model.addAttribute("newBook", new Book());
        model.addAttribute("library", libraryService.getAll());
        return "library";
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('developers:read')")
    public String findById(@PathVariable int id, Model model) {
        model.addAttribute("book", libraryService.findById(id));
        return "book";
    }

    @GetMapping("delete/{id}")
    @PreAuthorize("hasAnyAuthority('developers:write')")
    public String delete(@PathVariable int id) {
        libraryService.delete(id);
        return "redirect:/library";
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('developers:write')")
    public String createBook(@ModelAttribute("newBook") Book book) {
        libraryService.createBook(book);
        return "redirect:/library";
    }

}
