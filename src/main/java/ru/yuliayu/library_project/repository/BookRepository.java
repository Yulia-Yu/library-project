package ru.yuliayu.library_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.model.Book;

import java.util.List;

public interface  BookRepository extends JpaRepository<Book, Long> {
    List<Book> findGenreByGenreId(Long genreId);
}
