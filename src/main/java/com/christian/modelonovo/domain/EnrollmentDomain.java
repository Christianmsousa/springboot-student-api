package com.christian.modelonovo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrollment")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EnrollmentDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "course_id")
    @JsonIgnoreProperties({ "duration", "students" })
    private CourseDomain course;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "student_id")
    @JsonIgnoreProperties("courses")
    private StudentDomain student;

    public static EnrollmentDomain fromEnrollmentService(CourseDomain course, StudentDomain student) {
        return new EnrollmentDomain(null, course, student);
    }
}
