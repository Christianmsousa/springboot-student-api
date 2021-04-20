package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.SubjectDomain;
import com.christian.modelonovo.domain.TeacherDomain;
import com.christian.modelonovo.exceptions.NotFoundException;
import com.christian.modelonovo.filters.SubjectFilter;
import com.christian.modelonovo.interfaces.json.TeacherControlJson;
import com.christian.modelonovo.repository.SubjectRepository;
import com.christian.modelonovo.repository.TeacherRepository;
import com.christian.modelonovo.services.TeacherControlService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeacherControlServiceImpl implements TeacherControlService {

  @Autowired
  TeacherRepository teacherRepository;

  @Autowired
  SubjectRepository subjectRepository;

  @Override
  public SubjectDomain createTeacherControl(
    TeacherControlJson teacherControlJson
  ) {
    TeacherDomain teacher = teacherRepository
      .findById(teacherControlJson.getTeacher_id())
      .orElseThrow(NotFoundException::new);
    SubjectDomain subject = subjectRepository
      .findById(teacherControlJson.getSubject_id())
      .orElseThrow(NotFoundException::new);

    subject.setTeacher(teacher);

    return subjectRepository.save(subject);
  }

  @Override
  public Page<SubjectDomain> getTeacherControl(
    Pageable page,
    Optional<String> subject
  ) {
    Pageable pageAble = PageRequest.of(
      page.getPageNumber(),
      page.getPageSize()
    );
    if(subject.isPresent()){

      SubjectFilter subjectFilter = SubjectFilter.builder().subject(subject.get()).build();
      return subjectRepository.findAll(subjectFilter.predicate(), pageAble);
    }
    return subjectRepository.findAll(pageAble);
  }
}
