package org.example.book.controller;

import lombok.RequiredArgsConstructor;
import org.example.book.dao.repository.StudentRepository;
import org.example.book.dto.StudentRequestDTO;
import org.example.book.dto.StudentResponseDTO;
import org.example.book.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("api/v1/student")
@RestController
public class StudentController {
    private final StudentService studentService;

    @PostMapping("add")
    public void addStudent(@RequestBody StudentRequestDTO dto){
        studentService.addStudent(dto);
    }

    @GetMapping("list")
    public List<StudentResponseDTO> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("{id}")
    public StudentResponseDTO getStudent(@PathVariable Long id ){
        return studentService.getStudent(id);
    }


    @GetMapping("price-range")
    public List<StudentResponseDTO> getStudentsByPriceRange (
            @RequestParam Integer minbalance,
            @RequestParam Integer maxbalance){
        return studentService.getStudentsByBalanceRange(minbalance,maxbalance);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent (@PathVariable Long id){

        studentService.deleteStudent(id);
    }


    @GetMapping("name")
    public List<StudentResponseDTO> getStudentsByName(
            @RequestParam String name){
        return studentService.getStudentsByName(name);
    }


}

