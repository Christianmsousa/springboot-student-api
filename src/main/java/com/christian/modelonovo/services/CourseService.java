package com.christian.modelonovo.services;

import com.christian.modelonovo.domain.CourseDomain;
import com.christian.modelonovo.interfaces.json.CourseJson;

import java.util.List;

public interface CourseService {
    CourseDomain createCourse(CourseJson courseJson);

    List<CourseDomain> getAllCourse();
}
