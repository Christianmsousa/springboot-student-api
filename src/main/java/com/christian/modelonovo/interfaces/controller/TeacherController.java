package com.christian.modelonovo.interfaces.controller;

import com.christian.modelonovo.domain.TeacherDomain;
import com.christian.modelonovo.interfaces.json.TeacherJson;
import com.christian.modelonovo.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
@Validated
public class TeacherController {

  @Autowired
  TeacherService teacherService;

  @PostMapping
  public ResponseEntity<TeacherDomain> createTeacher(@RequestBody TeacherJson teacherJson) {
    var teacher = teacherService.createTeacher(teacherJson);
    return ResponseEntity.status(HttpStatus.CREATED).body(teacher);
  }

  @GetMapping
  public Page<TeacherDomain> getStudent(
    Pageable page,
    @RequestParam(name = "email", required = false) String email
  ) {
    return teacherService.getTeacher(page, email);
  }
}
