package com.christian.modelonovo.interfaces.json;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherControlJson {

  @NotNull
  private Long subject_id;

  @NotNull
  private Long teacher_id;
}
