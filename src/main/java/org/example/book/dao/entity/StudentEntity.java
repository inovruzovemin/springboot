package org.example.book.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.book.utill.enums.Gender;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Gender gender;
    @Builder.Default
    private boolean isActive=false;
    private LocalDate birthDate;
    @CreationTimestamp
    private LocalDate createDate;
    @UpdateTimestamp
    private LocalDate updateDate;
    private Integer active_balance;


}
