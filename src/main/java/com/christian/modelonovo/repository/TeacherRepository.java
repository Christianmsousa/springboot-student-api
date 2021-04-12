package com.christian.modelonovo.repository;

import com.christian.modelonovo.domain.TeacherDomain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository
    extends JpaRepository<TeacherDomain, Long>, QuerydslPredicateExecutor<TeacherDomain> {

}
