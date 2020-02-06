package com.walmart.test.apitest.service;

import com.walmart.test.apitest.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student getById(Integer id);
    List<Student> findAll();
}
