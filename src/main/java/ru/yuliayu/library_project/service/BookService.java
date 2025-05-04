package ru.yuliayu.library_project.service;

import ru.yuliayu.library_project.dto.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> getBookByGenre(Long genreId);

    BookDto getByNameV1(String name);

    BookDto getByNameV2(String name);

    BookDto getByNameV3(String name);
}
