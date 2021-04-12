package com.christian.modelonovo.domain;

import com.christian.modelonovo.interfaces.json.CourseJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "course")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CourseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "duration", nullable = false)
    private Long duration;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "class_control", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
    // @JsonIgnoreProperties({ "age", "courses", "email" })
    private List<SubjectDomain> subjects;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "enrollment", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    @JsonIgnoreProperties({ "age", "courses", "email" })
    private List<StudentDomain> students;

    public CourseDomain(String name, Long duration) {
        this.name = name;
        this.duration = duration;
    }

    public static CourseDomain fromCourseJson(CourseJson courseJson) {

        return new CourseDomain(courseJson.getName().toLowerCase(), courseJson.getDuration());
    }

}
