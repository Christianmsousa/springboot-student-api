package com.christian.modelonovo.filters;

import java.util.List;
import java.util.Objects;

import com.christian.modelonovo.domain.QStudentDomain;
import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import lombok.Builder;

@Builder
public class StudentFilter {
  private String email;

  public Predicate predicate() {
    QStudentDomain studentDomain = QStudentDomain.studentDomain;
    List<Predicate> predicateList = Lists.newArrayList();
    if (Objects.nonNull(email)) {
      predicateList.add(studentDomain.email.eq(email));
    }
    return ExpressionUtils.allOf(predicateList);
  }
}
