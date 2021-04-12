package com.christian.modelonovo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import com.christian.modelonovo.interfaces.json.SubjectJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

// import java.util.List;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subject")
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SubjectDomain {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id")
  // @OneToOne(mappedBy = "subject")
  @JsonIgnoreProperties({ "subject" })
  private TeacherDomain teacher;

  public SubjectDomain(String name) {
    this.name = name;
  }

  public static SubjectDomain fromSubjectJson(SubjectJson subject) {
    return new SubjectDomain(subject.getName().toLowerCase());
  }
}
