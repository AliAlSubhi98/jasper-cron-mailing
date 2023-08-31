package com.alialsubhi.jaspercronmailing.Controllers;

import com.alialsubhi.jaspercronmailing.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //  CRUD endpoints



}
