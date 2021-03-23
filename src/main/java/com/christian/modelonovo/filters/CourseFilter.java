package com.christian.modelonovo.filters;

import java.util.List;
import java.util.Objects;

import com.christian.modelonovo.domain.QCourseDomain;
import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;

import lombok.Builder;

@Builder
public class CourseFilter {
  private String name;

  public Predicate predicate() {
    QCourseDomain courseDomain = QCourseDomain.courseDomain;
    List<Predicate> predicateList = Lists.newArrayList();
    if (Objects.nonNull(name)) {
      predicateList.add(courseDomain.name.eq(name));
    }
    return ExpressionUtils.allOf(predicateList);
  }
}