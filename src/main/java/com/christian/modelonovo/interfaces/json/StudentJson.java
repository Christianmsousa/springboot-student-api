package com.christian.modelonovo.interfaces.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentJson {

    @NotBlank
    @NotNull
    private String name;

    // @NotEmpty
    @NotNull
    @Email
    private String email;

    @NotNull
    @Range(min = 7, max = 150)
    private Long age;

}
