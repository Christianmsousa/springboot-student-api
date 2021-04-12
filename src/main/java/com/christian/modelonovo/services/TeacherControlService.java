package com.christian.modelonovo.services;

import java.util.Optional;

import com.christian.modelonovo.domain.SubjectDomain;
import com.christian.modelonovo.interfaces.json.TeacherControlJson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherControlService {
  SubjectDomain createTeacherControl(TeacherControlJson teacherControlJson);

  Page<SubjectDomain> getTeacherControl(Pageable page, Optional<String> subject, Optional<String> teacher);

}
