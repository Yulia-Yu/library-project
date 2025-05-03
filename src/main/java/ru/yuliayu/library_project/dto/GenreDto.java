package ru.yuliayu.library_project.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Data
public class GenreDto {
    private Long id;
    private String name;

    private List<BookDto> books;
}
