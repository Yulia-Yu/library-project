package ru.yuliayu.library_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import ru.yuliayu.library_project.dto.BookDto;
import ru.yuliayu.library_project.model.Book;

import java.util.List;
import java.util.Optional;

public interface  BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    List<Book> findGenreByGenreId(Long genreId);

    Optional<Book> findBookByName(String name);

    @Query(nativeQuery = true, value = "SELECT * FROM BOOK WHERE name = ?")
    Optional<Book> findBookByNameBySql(String name);

}
