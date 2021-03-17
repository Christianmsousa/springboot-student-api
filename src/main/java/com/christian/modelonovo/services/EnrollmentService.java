package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.EnrollmentDomain;
import com.christian.modelonovo.interfaces.json.EnrollmentJson;

import java.util.List;

public interface EnrollmentService {
    EnrollmentDomain createEnrollment(EnrollmentJson enrollmentJson);

    List<EnrollmentDomain> getAllEnrollment();
}
