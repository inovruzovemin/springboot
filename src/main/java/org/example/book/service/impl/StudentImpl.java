package org.example.book.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.book.dao.entity.StudentEntity;
import org.example.book.dao.repository.StudentRepository;
import org.example.book.dto.StudentRequestDTO;
import org.example.book.dto.StudentResponseDTO;
import org.example.book.mapper.StudentMapper;
import org.example.book.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentImpl implements StudentService {
    public final StudentRepository studentRepository;
    public final StudentMapper studentMapper;

    @Override
    public void addStudent(StudentRequestDTO dto) {
        var entity = StudentEntity.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .birthDate(dto.getBirthDate())
                .gender(dto.getGender())
                .build();
        studentRepository.save(entity);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentResponseDTO> getStudents() {
     return studentMapper.entityListToDtoList(studentRepository.findAll());
    }

    @Override
    public StudentResponseDTO getStudent(Long id) {
        var optionalStudentEntity = studentRepository.findById(id);
        if(optionalStudentEntity.isPresent()){
            return studentMapper.entityToDto(optionalStudentEntity.get());
        }
        return studentMapper.entityToDto(StudentEntity.builder().build());

    }

    @Override
    public List<StudentResponseDTO> getStudentsByBalanceRange(Integer minbalance, Integer maxbalance) {
        return studentMapper.entityListToDtoList(studentRepository.findByBalanceBetween(minbalance,maxbalance));
    }

    @Override
    public List<StudentResponseDTO> getStudentsByName(String name) {
        return studentMapper.entityListToDtoList(studentRepository.findByName(name));
    }

    @Override
    public List<StudentResponseDTO> getStudentsByNameComponent(String namec) {
        return studentMapper.entityListToDtoList(studentRepository.findByNameComponent(namec));
    }

    @Override
    public Long getStudentsCount() {
        return studentRepository.count();
    }

    @Override
    public StudentResponseDTO getStudentByMaxBalance() {
        return studentMapper.entityToDto(studentRepository.findTopByActive_balance());
    }

    @Override
    public List<StudentResponseDTO> getLastStudents() {
        return null;
    }
}
