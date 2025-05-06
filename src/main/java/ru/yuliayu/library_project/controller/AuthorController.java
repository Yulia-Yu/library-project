package ru.yuliayu.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yuliayu.library_project.dto.AuthorCreateDto;
import ru.yuliayu.library_project.dto.AuthorUpdateDto;
import ru.yuliayu.library_project.dto.AuthorDto;
import ru.yuliayu.library_project.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping("/author/id/{id}")
    AuthorDto getAuthorById(@PathVariable("id") Long id) {
        return authorService.getAuthorById(id);
    }

    @GetMapping("/author")
    AuthorDto getAuthorByName(@RequestParam("name") String name){
        return authorService.getAuthorByNameV1(name);
    }

    @GetMapping("/author/v2")
    AuthorDto getAuthorByNameV2(@RequestParam("name") String name){
        return authorService.getAuthorByNameV2(name);
    }
    @GetMapping("/author/v3")
    AuthorDto getAuthorByNameV3(@RequestParam("name") String name){
        return authorService.getAuthorByNameV3(name);
    }

    @PostMapping("/author/create")
    AuthorDto createAuthor(@RequestBody AuthorCreateDto authorCreateDto) {
        return authorService.createAuthor(authorCreateDto);
    }

    @PutMapping("/author/update")
    AuthorDto updateAuthor(@RequestBody AuthorUpdateDto authorUpdateDto) {
        return authorService.updateAuthor(authorUpdateDto);
    }

    @DeleteMapping("author/delete/{id}")
    void deleteAuthor(@PathVariable("id") Long id){
        authorService.deleteAuthor(id);
    }
}
