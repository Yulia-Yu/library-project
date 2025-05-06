package ru.yuliayu.library_project.service;

import ru.yuliayu.library_project.dto.AuthorCreateDto;
import ru.yuliayu.library_project.dto.AuthorDto;
import ru.yuliayu.library_project.dto.AuthorUpdateDto;
import ru.yuliayu.library_project.dto.BookDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByNameV1(String name);

    AuthorDto getAuthorByNameV2(String name);

    AuthorDto getAuthorByNameV3(String name);

    AuthorDto createAuthor(AuthorCreateDto authorCreateDto);
    AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto);
    void deleteAuthor(Long id);
}
