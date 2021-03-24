package com.christian.modelonovo.interfaces.controller;

import java.util.Optional;

import com.christian.modelonovo.domain.EnrollmentDomain;
import com.christian.modelonovo.interfaces.json.EnrollmentJson;
import com.christian.modelonovo.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(tags = "/enrollment", description = "matriculas")
@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<EnrollmentDomain> createEnrollment(@RequestBody EnrollmentJson enrollmentJson) {

        var enroll = enrollmentService.createEnrollment(enrollmentJson);
        return ResponseEntity.status(HttpStatus.CREATED).body(enroll);

    }

    @GetMapping
    public Page<EnrollmentDomain> getEnrollment(Pageable page,
            @ApiParam(name = "course", type = "String", required = false) @RequestParam(name = "course", required = false) Optional<String> course,
            @ApiParam(name = "student", type = "String", required = false) @RequestParam(name = "student", required = false) Optional<String> student) {

        return enrollmentService.getEnrollment(page, course, student);
    }

    @GetMapping("/{id}")
    public EnrollmentDomain findById(@PathVariable(value = "id") Long Id) {
        return enrollmentService.findById(Id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long Id) {
        enrollmentService.delete(Id);
    }
}
