package com.christian.modelonovo.repository;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.domain.EnrollmentDomain;
import com.christian.modelonovo.domain.StudentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrollmentRepository
  extends
    JpaRepository<EnrollmentDomain, Long>,
    QuerydslPredicateExecutor<EnrollmentDomain> {
  // @Query(value = "SELECT * FROM enrollment WHERE course_id = :course AND
  // student_id = :student", nativeQuery = true)
  // EnrollmentDomain exists(@Param("course") Long course, @Param("student") Long
  // student);

  // Optional<EnrollmentDomain> WhereCourse_idAndStudent_id(Long courseId, Long
  // studentId);

  Boolean existsByCourseAndStudent(CourseDomain course, StudentDomain student);
}
