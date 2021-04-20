package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.interfaces.json.CourseJson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
  CourseDomain createCourse(CourseJson courseJson);

  Page<CourseDomain> getCourse(Pageable page, String name);

  CourseDomain findById(Long Id);

  void delete(Long Id);
}
