package com.christian.modelonovo.interfaces.controller;

import com.christian.modelonovo.domain.SubjectDomain;
import com.christian.modelonovo.interfaces.json.SubjectJson;
import com.christian.modelonovo.services.SubjectService;
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
@RequestMapping("/subject")
public class SubjectController {

  @Autowired
  private SubjectService subjectService;

  @PostMapping
  public ResponseEntity<SubjectDomain> createSubject(
    @RequestBody SubjectJson subjectJson
  ) {
    var subject = subjectService.createSubject(subjectJson);
    return ResponseEntity.status(HttpStatus.CREATED).body(subject);
  }

  @GetMapping
  public Page<SubjectDomain> getSubject(
    @RequestParam(name = "name", required = false) String name,
    Pageable page
  ) {
    return subjectService.getSubject(page, name);
  }
}
