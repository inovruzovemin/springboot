package org.example.book.mapper;

import org.example.book.dao.entity.StudentEntity;
import org.example.book.dao.repository.StudentRepository;
import org.example.book.dto.StudentResponseDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentMapper {

    public List<StudentResponseDTO> entityListToDtoList(List<StudentEntity> entityList) {
        List<StudentResponseDTO> dtos = new ArrayList<>();

        for (StudentEntity e : entityList) {

            var dto = StudentResponseDTO.builder()
                    .firstName(e.getFirstName())
                    .lastName(e.getLastName())
                    .birthDate(e.getBirthDate())
                    .gender(e.getGender())
                    .isActive(e.isActive())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    public StudentResponseDTO entityToDto(StudentEntity entity){
        return StudentResponseDTO.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .birthDate(entity.getBirthDate())
                .gender(entity.getGender())
                .isActive(entity.isActive())
                .build();
    }


}