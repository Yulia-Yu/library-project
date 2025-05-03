package ru.yuliayu.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.yuliayu.library_project.dto.GenreDto;
import ru.yuliayu.library_project.service.GenreService;

@RequiredArgsConstructor
@RestController
public class GenreController {
    private final GenreService genreService;

    @GetMapping("/genre/{id}")
    GenreDto getGenreById(@PathVariable("id") Long id) {
        return genreService.getGenreById(id);
    }
}
