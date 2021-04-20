package com.christian.modelonovo.interfaces.json;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassControlJson {

  @NotNull
  private Long course_id;

  @NotNull
  private Long subject_id;
}
