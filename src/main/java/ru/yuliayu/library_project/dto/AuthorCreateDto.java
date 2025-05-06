package ru.yuliayu.library_project.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Data
public class AuthorCreateDto {
    private String name;
    private String surname;
}
