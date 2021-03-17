package com.christian.modelonovo.interfaces.controller;

import com.christian.modelonovo.domain.EnrollmentDomain;
import com.christian.modelonovo.interfaces.json.EnrollmentJson;
import com.christian.modelonovo.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@Api(tags = "/enrollment", description = "matriculas")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping(path = "/enrollment")
    public ResponseEntity<EnrollmentDomain> createEnrollment(@RequestBody EnrollmentJson enrollmentJson) {

        var enroll = enrollmentService.createEnrollment(enrollmentJson);
        return ResponseEntity.status(HttpStatus.CREATED).body(enroll);

    }

    @GetMapping(path = "/enrollment")
    public List<EnrollmentDomain> getAllEnrollment() {
        return enrollmentService.getAllEnrollment();
    }
}
