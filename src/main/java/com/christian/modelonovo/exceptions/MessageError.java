package com.christian.modelonovo.exceptions;

import lombok.Data;

@Data
// @AllArgsConstructor
public class MessageError<T> {

  private String error;
  private Integer status;
  private T message;

  public MessageError(String error, Integer status, T list) {
    this.error = error;
    this.status = status;
    this.message = list;
  }

  // public MessageError(String error2, int status2, String message2) {
  // this.error = error;
  // this.status = status;
  // this.message = string;
  // }

}
