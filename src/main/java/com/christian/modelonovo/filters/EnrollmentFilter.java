package com.christian.modelonovo.filters;

import com.christian.modelonovo.domain.QEnrollmentDomain;
import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.Optional;
import lombok.Builder;

@Builder
public class EnrollmentFilter {

  private Optional<String> course;
  private Optional<String> student;

  public Predicate predicate() {
    QEnrollmentDomain enrollmentDomain = QEnrollmentDomain.enrollmentDomain;
    List<Predicate> predicateList = Lists.newArrayList();
    if (course.isPresent()) {
      predicateList.add(
        enrollmentDomain.course.name.eq(course.get().toLowerCase())
      );
    }
    if (student.isPresent()) {
      predicateList.add(
        enrollmentDomain.student.email.eq(student.get().toLowerCase())
      );
    }
    return ExpressionUtils.allOf(predicateList);
  }
}
