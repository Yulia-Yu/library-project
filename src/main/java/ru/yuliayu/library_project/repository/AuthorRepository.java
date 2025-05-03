package ru.yuliayu.library_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yuliayu.library_project.model.Author;

public interface  AuthorRepository extends JpaRepository<Author, Long> {
}
