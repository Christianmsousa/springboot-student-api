package com.christian.modelonovo.interfaces.json;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseJson {

  @NotBlank
  private String name;

  @NotBlank
  @Range(max = 5)
  private Long duration;

}
