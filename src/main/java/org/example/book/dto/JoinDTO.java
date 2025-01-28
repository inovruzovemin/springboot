package org.example.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.book.dao.entity.StudentEntity;
import org.example.book.dao.entity.SubjectEntity;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoinDTO {
    private Long studentId;
    private String studentName;
    private String subjectName;

}
