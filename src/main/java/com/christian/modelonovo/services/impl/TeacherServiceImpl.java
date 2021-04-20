package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.TeacherDomain;
import com.christian.modelonovo.exceptions.SyntaxErrorException;
import com.christian.modelonovo.filters.TeacherFilter;
import com.christian.modelonovo.interfaces.json.TeacherJson;
import com.christian.modelonovo.repository.TeacherRepository;
import com.christian.modelonovo.services.TeacherService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

  @Autowired
  TeacherRepository teacherRepository;

  @Override
  public TeacherDomain createTeacher(TeacherJson teacherJson) {
    String[] emailSplit = teacherJson.getEmail().split("@");
    String teacherEmail = emailSplit[1];

    var validEmail =
      teacherEmail.equalsIgnoreCase("gmail.com") ||
      teacherEmail.equalsIgnoreCase("yahoo.com");

    if (!validEmail) {
      throw new SyntaxErrorException();
    }

    var teacherDomain = TeacherDomain.fromTeacherJson(teacherJson);
    return teacherRepository.save(teacherDomain);
  }

  @Override
  public Page<TeacherDomain> getTeacher(Pageable page, String email) {
    Pageable pageAble = PageRequest.of(
      page.getPageNumber(),
      page.getPageSize()
    );

    if (Objects.nonNull(email)) {
      TeacherFilter teacherFilter = TeacherFilter
        .builder()
        .email(email)
        .build();

      return teacherRepository.findAll(teacherFilter.predicate(), pageAble);
    }

    return teacherRepository.findAll(pageAble);
  }
}
