package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.exceptions.NotFoundException;
import com.christian.modelonovo.filters.CourseFilter;
import com.christian.modelonovo.interfaces.json.CourseJson;
import com.christian.modelonovo.repository.CourseRepository;
import com.christian.modelonovo.services.CourseService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

  @Autowired
  CourseRepository courseRepository;

  @Override
  public CourseDomain createCourse(CourseJson courseJson) {
    var courseDomain = CourseDomain.fromCourseJson(courseJson);

    return courseRepository.save(courseDomain);
  }

  @Override
  public Page<CourseDomain> getCourse(Pageable page, String name) {
    Pageable pageAble = PageRequest.of(
      page.getPageNumber(),
      page.getPageSize()
    );
    if (Objects.nonNull(name)) {
      CourseFilter courseFilter = CourseFilter.builder().name(name).build();
      return courseRepository.findAll(courseFilter.predicate(), pageAble);
    }
    return courseRepository.findAll(pageAble);
  }

  @Override
  public CourseDomain findById(Long Id) {
    return courseRepository
      .findById(Id)
      .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public void delete(Long Id) {
    var course = courseRepository
      .findById(Id)
      .orElseThrow(() -> new NotFoundException());

    courseRepository.deleteById(course.getId());
  }
}
