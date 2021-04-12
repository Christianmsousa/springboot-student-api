package com.christian.modelonovo.interfaces.controller;

import java.util.Optional;

import com.christian.modelonovo.domain.SubjectDomain;
import com.christian.modelonovo.interfaces.json.TeacherControlJson;
import com.christian.modelonovo.services.TeacherControlService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/control")
public class TeacherControlController {

  @Autowired
  TeacherControlService teacherControlService;

  @PostMapping
  public ResponseEntity<SubjectDomain> createTeacherControl(@RequestBody TeacherControlJson teacherControlJson) {
    var teacherControl = teacherControlService.createTeacherControl(teacherControlJson);

    return ResponseEntity.status(HttpStatus.CREATED).body(teacherControl);
  }

  @GetMapping
  public Page<SubjectDomain> getTeacherControl(@RequestBody Optional<String> subject, Optional<String> teacher,
      Pageable page) {

    var teacherControl = teacherControlService.getTeacherControl(page, subject, teacher);
    return teacherControl;
  }

}
