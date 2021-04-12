package com.christian.modelonovo.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "class_control")
public class ClassControlDomain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "course_id")
  private CourseDomain course;

  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "subject_id")
  private SubjectDomain subject;

  public static ClassControlDomain fromClassControlJson(CourseDomain course, SubjectDomain subject) {
    return new ClassControlDomain(null, course, subject);
  }
}
