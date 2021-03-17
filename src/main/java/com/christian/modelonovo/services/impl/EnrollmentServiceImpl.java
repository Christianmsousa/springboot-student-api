package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.domain.EnrollmentDomain;
import com.christian.modelonovo.domain.StudentDomain;
import com.christian.modelonovo.exceptions.AlreadyRegisteredExeception;
import com.christian.modelonovo.exceptions.NotFoundException;
import com.christian.modelonovo.interfaces.json.EnrollmentJson;
import com.christian.modelonovo.repository.CourseRepository;
import com.christian.modelonovo.repository.EnrollmentRepository;
import com.christian.modelonovo.repository.StudentRepository;
import com.christian.modelonovo.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public EnrollmentDomain createEnrollment(EnrollmentJson enrollmentJson) {

        CourseDomain course = courseRepository.findById(enrollmentJson.getCourse_id())
                .orElseThrow(NotFoundException::new);
        StudentDomain student = studentRepository.findById(enrollmentJson.getStudent_id())
                .orElseThrow(NotFoundException::new);

        var alreadyRegister = enrollmentRepository.existsByCourseAndStudent(course, student);

        if (alreadyRegister) {
            throw new AlreadyRegisteredExeception();

        }
        var enrollmentDomain = EnrollmentDomain.fromEnrollmentService(course, student);

        return enrollmentRepository.save(enrollmentDomain);
    }

    @Override
    public List<EnrollmentDomain> getAllEnrollment() {

        return enrollmentRepository.findAll();
    }
}
