package com.christian.modelonovo.repository;

import com.christian.modelonovo.domain.StudentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
    extends JpaRepository<StudentDomain, Long>, QuerydslPredicateExecutor<StudentDomain> {
}