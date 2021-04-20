package com.christian.modelonovo.domain;

import com.christian.modelonovo.interfaces.json.TeacherJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
// import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class TeacherDomain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(name = "age", nullable = false)
  private Long age;

  // @OneToOne
  // @JoinColumn(name = "subject_id", referencedColumnName = "id")
  @OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
  @JoinColumn(name = "subject_id")
  @JsonIgnoreProperties({ "teacher" })
  private SubjectDomain subject;

  public TeacherDomain(String name, String email, Long age) {
    this.name = name;
    this.email = email;
    this.age = age;
  }

  public static TeacherDomain fromTeacherJson(TeacherJson teacher) {
    return new TeacherDomain(
      teacher.getName().toLowerCase(),
      teacher.getEmail().toLowerCase(),
      teacher.getAge()
    );
  }
}
