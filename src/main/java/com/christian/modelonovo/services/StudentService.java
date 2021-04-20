package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.StudentDomain;
import com.christian.modelonovo.interfaces.json.StudentJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
  StudentDomain createStudent(StudentJson studentJson);

  Page<StudentDomain> getStudent(Pageable page, String email);

  StudentDomain findById(Long Id);

  void delete(Long Id);
}
