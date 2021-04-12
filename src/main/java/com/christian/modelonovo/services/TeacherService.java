package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.TeacherDomain;
import com.christian.modelonovo.interfaces.json.TeacherJson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {

  TeacherDomain createTeacher(TeacherJson teacherJson);

  Page<TeacherDomain> getTeacher(Pageable page, String email);
}
