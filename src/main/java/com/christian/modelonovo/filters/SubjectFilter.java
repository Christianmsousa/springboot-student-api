package com.christian.modelonovo.filters;

import com.christian.modelonovo.domain.QSubjectDomain;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.ExpressionUtils;
import java.util.List;
import java.util.Objects;

import com.google.common.collect.Lists;
import lombok.Builder;

@Builder
public class SubjectFilter {

  private String name;

  public Predicate predicate() {

    QSubjectDomain subjectDomain = QSubjectDomain.subjectDomain;

    List<Predicate> predicateList = Lists.newArrayList();
    if (Objects.nonNull(name)) {
      predicateList.add(subjectDomain.name.eq(name.toLowerCase()));
    }

    return ExpressionUtils.allOf(predicateList);
  }
}
