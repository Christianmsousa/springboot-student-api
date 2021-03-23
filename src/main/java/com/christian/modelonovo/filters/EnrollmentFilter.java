package com.christian.modelonovo.filters;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.google.common.collect.Lists;

import com.christian.modelonovo.domain.QEnrollmentDomain;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.ExpressionUtils;

import lombok.Builder;

@Builder
public class EnrollmentFilter {
  private Optional<String> course;
  private Optional<String> student;

  public Predicate predicate() {
    QEnrollmentDomain enrollmentDomain = QEnrollmentDomain.enrollmentDomain;
    List<Predicate> predicateList = Lists.newArrayList();
    if (course.isPresent()) {
      predicateList.add(enrollmentDomain.course.name.eq(course.get().toLowerCase()));
    }
    if (student.isPresent()) {
      predicateList.add(enrollmentDomain.student.email.eq(student.get().toLowerCase()));
    }
    return ExpressionUtils.allOf(predicateList);
  }

}
