package ru.yuliayu.library_project.service;

import ru.yuliayu.library_project.dto.AuthorDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
}
