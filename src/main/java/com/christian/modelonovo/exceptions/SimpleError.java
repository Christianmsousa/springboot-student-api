package com.christian.modelonovo.exceptions;

import org.springframework.validation.FieldError;

import lombok.Data;

@Data
public class SimpleError {
  private String field;
  private String message;

  public SimpleError(FieldError error) {
    this.field = error.getField();
    this.message = error.getDefaultMessage();

  }

}
