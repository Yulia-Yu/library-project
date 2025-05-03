package ru.yuliayu.library_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yuliayu.library_project.dto.AuthorDto;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.model.Book;
import ru.yuliayu.library_project.repository.BookRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<BookDto>  getBookByGenre(Long id){
        List<Book> books = bookRepository.findGenreByGenreId(id);
        return convertToDto(books);
    }

    private List<BookDto> convertToDto(List<Book> books){
        return books.stream()
                .map(book -> {
                    List<AuthorDto> authorDtoList = book.getAuthors().stream()
                            .map(author -> AuthorDto.builder()
                                    .surname(author.getSurname())
                                    .name(author.getName())
                                    .id(author.getId())
                                    .build())
                            .toList();

                    return BookDto.builder()
                            .id(book.getId())
                            .name(book.getName())
                            .authors(authorDtoList)
                            .build();
                })
                .toList();
    }

}
