package com.christian.modelonovo.interfaces.json;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentJson {

  @NotBlank
  @NotNull
  private String name;

  @NotNull
  @Email
  private String email;

  @NotNull
  @Range(min = 7, max = 150)
  private Long age;
}
