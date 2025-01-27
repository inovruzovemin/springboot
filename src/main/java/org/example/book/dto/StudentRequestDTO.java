package org.example.book.dto;

import lombok.*;
import org.example.book.utill.enums.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
}
