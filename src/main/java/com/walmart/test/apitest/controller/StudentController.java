package com.walmart.test.apitest.controller;

import com.walmart.test.apitest.dto.StudentDto;
import com.walmart.test.apitest.model.Student;
import com.walmart.test.apitest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping
    ResponseEntity<?> get(@RequestParam( defaultValue = "asc", required = false) String sort){//
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity<?> get(@PathVariable("id") Integer id){//
        Student student = studentService.getById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<?> post(@RequestBody StudentDto studentDto){//
        Student student = new Student(studentDto);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

}
