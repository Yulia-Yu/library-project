package ru.yuliayu.library_project.service;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.yuliayu.library_project.dto.AuthorCreateDto;
import ru.yuliayu.library_project.dto.AuthorDto;
import ru.yuliayu.library_project.dto.AuthorUpdateDto;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.model.Author;
import ru.yuliayu.library_project.model.Book;
import ru.yuliayu.library_project.repository.AuthorRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository authorRepository;

    @Override
    public AuthorDto getAuthorById (Long id){
        Author author = authorRepository.findById(id).orElseThrow();
        return convertToDto(author);
    }

    @Override
    public AuthorDto getAuthorByNameV1(String name) {
        Author author = authorRepository.findAuthorByName(name).orElseThrow();
        return convertEntityToDto(author);
    }

    @Override
    public AuthorDto getAuthorByNameV2(String name) {
        Author author = authorRepository.findAuthorByNameBySql(name).orElseThrow();
        return convertEntityToDto(author);
    }

   @Override
    public AuthorDto getAuthorByNameV3(String name) {
        Specification<Author> specification = Specification.where(new Specification<Author>() {
            @Override
            public jakarta.persistence.criteria.Predicate toPredicate(Root<Author> root,
                                                                      CriteriaQuery<?> query,
                                                                      CriteriaBuilder cb) {
                return (jakarta.persistence.criteria.Predicate) cb.equal(root.get("name"), name);
            }
        });

        Author author = authorRepository.findOne(specification).orElseThrow();
        return convertEntityToDto(author);
    }


    @Override
    public AuthorDto createAuthor(AuthorCreateDto authorCreateDto){
        Author author = authorRepository.save(convertDtoToEntity(authorCreateDto));
        AuthorDto authorDto = convertEntityToDto(author);
        return authorDto;
    }

    @Override
    public AuthorDto updateAuthor(AuthorUpdateDto authorUpdateDto) {
        Author author = authorRepository.findById(authorUpdateDto.getId()).orElseThrow();
        author.setName(authorUpdateDto.getName());
        author.setSurname(authorUpdateDto.getSurname());
        Author savedAuthor = authorRepository.save(author);
        return convertEntityToDto(savedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDto> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }


    private AuthorDto convertToDto(Author author) {
        List<BookDto> bookDtoList = author.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build()
                ).toList();
        return AuthorDto.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();


    }

    private AuthorDto convertEntityToDto(Author author){
        List<BookDto> bookDtoList = null;
        if (author.getBooks() != null) {
            bookDtoList = author.getBooks()
                    .stream()
                    .map(book -> BookDto.builder()
                            .genre(book.getGenre().getName())
                            .name(book.getName())
                            .id(book.getId())
                            .build())
                    .toList();
        }
        return AuthorDto.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }

    private Author convertDtoToEntity(AuthorCreateDto authorCreateDto){
        return Author.builder()
                .name(authorCreateDto.getName())
                .surname(authorCreateDto.getSurname())
                .build();
    }

}


