package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.StudentDomain;
import com.christian.modelonovo.interfaces.json.StudentJson;

import java.util.List;

public interface StudentService {
    StudentDomain createStudent(StudentJson studentJson);

    List<StudentDomain> getAllStudent();
}
