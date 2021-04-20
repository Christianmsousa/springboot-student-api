package com.christian.modelonovo.exceptions;

import lombok.Data;
import org.springframework.validation.FieldError;

@Data
public class SimpleError {

  private String field;
  private String message;

  public SimpleError(FieldError error) {
    this.field = error.getField();
    this.message = error.getDefaultMessage();
  }
}
