package com.christian.modelonovo.interfaces.controller;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.interfaces.json.CourseJson;
import com.christian.modelonovo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

@Api(tags = "/course", description = "cursos")
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDomain> createCourse(@Validated @RequestBody CourseJson courseJson) {

        var course = courseService.createCourse(courseJson);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping
    public Page<CourseDomain> getCourse(
            @ApiParam(name = "name", type = "String", required = false) @RequestParam(name = "name", required = false) String name,
            Pageable page) {
        return courseService.getCourse(page, name);
    }

    @GetMapping("/{id}")
    public CourseDomain findById(@PathVariable(value = "id") Long Id) {
        return courseService.findById(Id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable(value = "id") Long Id) {
        courseService.delete(Id);
    }
}
