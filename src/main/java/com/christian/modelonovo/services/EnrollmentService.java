package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.EnrollmentDomain;
import com.christian.modelonovo.interfaces.json.EnrollmentJson;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface EnrollmentService {
    EnrollmentDomain createEnrollment(EnrollmentJson enrollmentJson);

    Page<EnrollmentDomain> getEnrollment(Pageable page, Optional<String> course, Optional<String> student);
}
