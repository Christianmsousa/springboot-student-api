package com.christian.modelonovo.interfaces.controller;

import com.christian.modelonovo.domain.SubjectDomain;
import com.christian.modelonovo.interfaces.json.TeacherControlJson;
import com.christian.modelonovo.services.TeacherControlService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/control")
public class TeacherControlController {

  @Autowired
  TeacherControlService teacherControlService;

  @PostMapping
  public ResponseEntity<SubjectDomain> createTeacherControl(
    @RequestBody TeacherControlJson teacherControlJson
  ) {
    var teacherControl = teacherControlService.createTeacherControl(
      teacherControlJson
    );

    return ResponseEntity.status(HttpStatus.CREATED).body(teacherControl);
  }

  @GetMapping
  public Page<SubjectDomain> getTeacherControl(
    @RequestParam(name = "subject", required = false) Optional<String> subject,
    Pageable page
  ) {
    var teacherControl = teacherControlService.getTeacherControl(
      page,
      subject
    );
    return teacherControl;
  }
}
