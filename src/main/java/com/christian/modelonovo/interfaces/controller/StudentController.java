package com.christian.modelonovo.interfaces.controller;

import com.christian.modelonovo.domain.StudentDomain;
import com.christian.modelonovo.interfaces.json.StudentJson;
import com.christian.modelonovo.services.StudentService;
// import com.christian.modelonovo.services.impl.StudentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(tags = "/student", description = "estudantes")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDomain> createStudent(@Validated @RequestBody StudentJson studentJson) {

        var student = studentService.createStudent(studentJson);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping
    public Page<StudentDomain> getStudent(Pageable page,
            @ApiParam(name = "email", type = "String", required = false) @RequestParam(name = "email", required = false) String email) {

        return studentService.getStudent(page, email);
    }
}
