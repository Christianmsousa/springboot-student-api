package com.christian.modelonovo.filters;

import com.christian.modelonovo.domain.QSubjectDomain;
import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.Objects;
import lombok.Builder;

@Builder
public class SubjectFilter {

  private String subject;

  public Predicate predicate() {
    QSubjectDomain subjectDomain = QSubjectDomain.subjectDomain;

    List<Predicate> predicateList = Lists.newArrayList();
    if (Objects.nonNull(subject)) {
      predicateList.add(subjectDomain.name.eq(subject.toLowerCase()));
    }
    return ExpressionUtils.allOf(predicateList);
  }
}
