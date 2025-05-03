package ru.yuliayu.library_project.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter

public class AuthorDto {
    private Long id;
    private String name;
    private String surname;

    private List<BookDto> books;
}
