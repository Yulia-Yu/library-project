package ru.yuliayu.library_project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.yuliayu.library_project.dto.BookCreateDto;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.dto.BookUpdateDto;
import ru.yuliayu.library_project.service.BookService;

import org.springframework.ui.Model;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/book")
    BookDto getBookByName(@RequestParam("name") String name) {
        return bookService.getByNameV1(name);
    }

    @GetMapping("/book/v2")
    BookDto getBookByNameV2(@RequestParam("name") String name) {
        return bookService.getByNameV2(name);
    }

    @GetMapping("/book/v3")
    BookDto getBookByNameV3(@RequestParam("name") String name) {
        return bookService.getByNameV3(name);
    }

    @PostMapping("/book/create")
    BookDto createBook(@RequestBody BookCreateDto bookCreateDto){
        return bookService.createBook(bookCreateDto);
    }

    @PutMapping("/book/update")
    BookDto updateBook(@RequestBody BookUpdateDto bookUpdateDto){
        return bookService.updateBook(bookUpdateDto);
    }

    @DeleteMapping("/book/delete/{id}")
    void deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
    }
}
