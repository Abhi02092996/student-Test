package com.api.controller;

import com.api.entity.Student;
import com.api.payload.StudentDto;
import com.api.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {


    private StudentService stdSer;

    public StudentController(StudentService stdSer) {
        this.stdSer = stdSer;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getData() {
        List<StudentDto> dto = stdSer.stdData();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDto studentDto, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }
        StudentDto saved = stdSer.addStudent(studentDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam long id) {
        stdSer.deleteStudent(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStd(@PathVariable long id, @RequestBody StudentDto studentDto) {
        StudentDto dto = stdSer.updateStd(id, studentDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable long id) {
        StudentDto dto = stdSer.getStudentById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

}
