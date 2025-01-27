package org.example.book.service;

import org.example.book.dto.StudentRequestDTO;
import org.example.book.dto.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    void addStudent(StudentRequestDTO dto);
    List<StudentResponseDTO> getStudents();
    StudentResponseDTO getStudent(Long id);
    List<StudentResponseDTO> getStudentsByBalanceRange(Integer minbalance, Integer maxbalance);
    List<StudentResponseDTO> getStudentsByName(String name);
}