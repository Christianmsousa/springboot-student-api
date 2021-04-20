package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.SubjectDomain;
import com.christian.modelonovo.filters.SubjectFilter;
import com.christian.modelonovo.interfaces.json.SubjectJson;
import com.christian.modelonovo.repository.SubjectRepository;
import com.christian.modelonovo.services.SubjectService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {

  @Autowired
  private SubjectRepository subjectRepository;

  @Override
  public SubjectDomain createSubject(SubjectJson subjectJson) {
    var subject = SubjectDomain.fromSubjectJson(subjectJson);

    return subjectRepository.save(subject);
  }

  @Override
  public Page<SubjectDomain> getSubject(Pageable page, String name) {
    Pageable pageAble = PageRequest.of(
      page.getPageNumber(),
      page.getPageSize()
    );

    if (Objects.nonNull(name)) {
      SubjectFilter subjectFilter = SubjectFilter.builder().subject(name).build();
      return subjectRepository.findAll(subjectFilter.predicate(), pageAble);
    }
    return subjectRepository.findAll(pageAble);
  }
}
