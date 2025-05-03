package ru.yuliayu.library_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yuliayu.library_project.model.Genre;

public interface  GenreRepository extends JpaRepository<Genre, Long> {
}
