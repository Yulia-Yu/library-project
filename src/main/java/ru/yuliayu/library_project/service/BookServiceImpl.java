package ru.yuliayu.library_project.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.yuliayu.library_project.dto.AuthorDto;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.model.Book;
import ru.yuliayu.library_project.repository.BookRepository;

import java.util.*;
import java.util.function.Predicate;

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

    @Override
    public BookDto getByNameV1(String name) {
        Book book = bookRepository.findBookByName(name).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV2(String name) {
        Book book = bookRepository.findBookByNameBySql(name).orElseThrow();
        return convertEntityToDto(book);
    }

    @Override
    public BookDto getByNameV3(String name) {
        Specification<Book> specification = Specification.where(new Specification<Book>() {
            @Override
            public jakarta.persistence.criteria.Predicate toPredicate(Root<Book> root,
                                                                      CriteriaQuery<?> query,
                                                                      CriteriaBuilder cb) {
                return (jakarta.persistence.criteria.Predicate) cb.equal(root.get("name"), name);
            }
        });

        Book book = bookRepository.findOne(specification).orElseThrow();
        return convertEntityToDto(book);
    }

    private BookDto convertEntityToDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .genre(book.getGenre().getName())
                .name(book.getName())
                .build();
    }

}
