package ru.yuliayu.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.yuliayu.library_project.service.AuthorService;

@Controller
@RequiredArgsConstructor
public class AuthorViewController {
    private final AuthorService authorService;

    @GetMapping("/authors")
    String getAuthorsView(Model model){
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors";
    }

}
