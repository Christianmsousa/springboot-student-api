package com.christian.modelonovo.exceptions;

public enum MessageErrorList {

  ALREADY_REGISTERED("Already registered"), USER_NOT_FOUND("Student or course not found"), SYNTAX_ERROR("Syntax Error");

  public String message;

  private MessageErrorList(String message) {
    this.message = message;
  }

}
