package com.christian.modelonovo.interfaces.controller;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.interfaces.json.CourseJson;
import com.christian.modelonovo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@Api(tags = "/course", description = "cursos")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(path = "/course")
    public ResponseEntity<CourseDomain> createCourse(@Validated @RequestBody CourseJson courseJson) {

        var course = courseService.createCourse(courseJson);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping(path = "/course")
    public List<CourseDomain> getAllCourse() {
        return courseService.getAllCourse();
    }
}
