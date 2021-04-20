package com.christian.modelonovo.exceptions;

public enum MessageErrorList {
  ALREADY_REGISTERED("Already registered"),
  NOT_FOUND("Student or course not found"),
  SYNTAX_ERROR("Syntax Error"),
  METHOD_INVALID("Method not permitted");

  public String message;

  private MessageErrorList(String message) {
    this.message = message;
  }
}
