package ru.yuliayu.library_project.service;

import ru.yuliayu.library_project.dto.BookCreateDto;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.dto.BookUpdateDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBookByGenre(Long genreId);

    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

    BookDto getByNameV3(String name);

    BookDto createBook(BookCreateDto bookCreateDto);
    BookDto updateBook(BookUpdateDto bookUpdateDto);
    void deleteBook(Long id);

    List<BookDto> getAllBooks();
}
