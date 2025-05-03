package ru.yuliayu.library_project.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yuliayu.library_project.dto.AuthorDto;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.dto.GenreDto;
import ru.yuliayu.library_project.model.Genre;
import ru.yuliayu.library_project.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor

public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final BookService bookService;

    @Override
    public GenreDto getGenreById(Long id){
        Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToDto(genre);
    }

    private GenreDto convertToDto(Genre genre){
        /*List<AuthorDto> authorsDtoList = book.getAuthor()
                .stream()
                .map(author -> AuthorDto.builder()
                        .id(author.getId())
                        .name(author.getName())
                        .surname(author.getSurname())
                        .build()
                ).toList();*/
        /*List<BookDto> bookDtoList = genre.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .id(book.getId())
                        .name(book.getName())
                        //.authors(authorsDtoList)
                        .build()
                ).toList();*/
        List<BookDto> bookDtoList = bookService.getBookByGenre(genre.getId());
        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(bookDtoList)
                .build();
    }
}
