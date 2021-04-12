package com.christian.modelonovo.interfaces.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseJson {

    @NotNull
    private String name;

    @NotNull
    @Range(max = 5)
    private Long duration;

    // @NotNull
    // private String au;

}
