package com.christian.modelonovo.services.impl;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.interfaces.json.CourseJson;
import com.christian.modelonovo.repository.CourseRepository;
import com.christian.modelonovo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public CourseDomain createCourse(CourseJson courseJson) {
        var courseDomain = CourseDomain.fromCourseJson(courseJson);

        return courseRepository.save(courseDomain);
    }

    @Override
    public List<CourseDomain> getAllCourse() {
        return courseRepository.findAll();
    }
}
