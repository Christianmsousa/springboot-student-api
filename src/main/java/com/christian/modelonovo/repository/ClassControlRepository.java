package com.christian.modelonovo.repository;

import com.christian.modelonovo.domain.ClassControlDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ClassControlRepository
  extends
    JpaRepository<ClassControlDomain, Long>,
    QuerydslPredicateExecutor<ClassControlDomain> {}
