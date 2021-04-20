package com.christian.modelonovo.filters;

import com.christian.modelonovo.domain.QTeacherDomain;
import com.google.common.collect.Lists;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import java.util.List;
import java.util.Objects;
import lombok.Builder;

@Builder
public class TeacherFilter {

  private String email;

  public Predicate predicate() {
    QTeacherDomain teacherDomain = QTeacherDomain.teacherDomain;
    List<Predicate> predicateList = Lists.newArrayList();

    if (Objects.nonNull(email)) {
      predicateList.add(teacherDomain.email.eq(email));
    }

    return ExpressionUtils.allOf(predicateList);
  }
}
