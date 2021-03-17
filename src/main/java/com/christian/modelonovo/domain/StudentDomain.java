package com.christian.modelonovo.domain;

import com.christian.modelonovo.interfaces.json.StudentJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StudentDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "age", nullable = false)
    private Long age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "enrollment", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnoreProperties("students")
    private List<CourseDomain> courses;

    public StudentDomain(String name, String email, Long age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public static StudentDomain fromStudentJson(StudentJson studentJson) {
        return new StudentDomain(studentJson.getName(), studentJson.getEmail(), studentJson.getAge());
    }

}
