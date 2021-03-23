package com.christian.modelonovo.repository;

import com.christian.modelonovo.domain.CourseDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CourseDomain, Long>, QuerydslPredicateExecutor<CourseDomain> {
}
