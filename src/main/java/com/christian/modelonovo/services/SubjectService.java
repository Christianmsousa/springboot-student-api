package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.SubjectDomain;
import com.christian.modelonovo.interfaces.json.SubjectJson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubjectService {
  SubjectDomain createSubject(SubjectJson subjectJson);

  Page<SubjectDomain> getSubject(Pageable page, String name);
}
