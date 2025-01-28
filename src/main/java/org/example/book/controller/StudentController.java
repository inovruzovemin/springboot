package org.example.book.controller;

import lombok.RequiredArgsConstructor;
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

//TASK1
    @GetMapping("price-range")
    public List<StudentResponseDTO> getStudentsByPriceRange (
            @RequestParam Integer minbalance,
            @RequestParam Integer maxbalance){
        return studentService.getStudentsByBalanceRange(minbalance,maxbalance);
    }
//TASK2
    @GetMapping("nc")
    public List<StudentResponseDTO> getStudentsByNameComponent (
            @RequestParam String namec){
        return studentService.getStudentsByNameComponent(namec);
    }
//TASK3
    @GetMapping("count")
    public String count(){
        return "Count: " + studentService.getStudentsCount();
    }
//TASK4
    @GetMapping("max")
    public StudentResponseDTO getStudentByMaxBalance(){
        return studentService.getStudentByMaxBalance();
    }
//TASK5
@GetMapping("son")
public List<StudentResponseDTO> getLastStudents(){
    return studentService.getLastStudents();
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

