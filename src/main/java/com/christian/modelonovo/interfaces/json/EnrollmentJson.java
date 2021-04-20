package com.christian.modelonovo.interfaces.json;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentJson {

  @NotNull
  private Long course_id;

  @NotNull
  private Long student_id;
}
