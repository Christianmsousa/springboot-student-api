package com.christian.modelonovo.repository;

import com.christian.modelonovo.domain.SubjectDomain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository
    extends JpaRepository<SubjectDomain, Long>, QuerydslPredicateExecutor<SubjectDomain> {

}
