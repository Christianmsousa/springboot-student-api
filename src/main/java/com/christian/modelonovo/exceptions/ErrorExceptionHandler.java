package com.christian.modelonovo.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorExceptionHandler {

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(AlreadyRegisteredExeception.class)
  public MessageError<MessageErrorList> alreadyRegisteredEnroll() {
    return new MessageError<MessageErrorList>("Conflict", 409, MessageErrorList.ALREADY_REGISTERED);
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(NotFoundException.class)
  public MessageError<MessageErrorList> notFound() {
    return new MessageError<MessageErrorList>("Not found", 404, MessageErrorList.USER_NOT_FOUND);
  }

  @ResponseStatus(HttpStatus.CONFLICT)
  @ExceptionHandler(DataIntegrityViolationException.class)
  public MessageError<MessageErrorList> alreadyRegistered() {
    return new MessageError<MessageErrorList>("Conflict", 409, MessageErrorList.ALREADY_REGISTERED);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(SyntaxErrorException.class)
  public MessageError<MessageErrorList> syntaxError() {
    return new MessageError<MessageErrorList>("Bad request", 400, MessageErrorList.SYNTAX_ERROR);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public MessageError<MessageErrorList> syntaxJsonError() {
    return new MessageError<MessageErrorList>("Bad request", 400, MessageErrorList.SYNTAX_ERROR);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public MessageError<List<SimpleError>> notAllowed(MethodArgumentNotValidException e) {
    return new MessageError<List<SimpleError>>("Bad request", 400, e.getBindingResult().getAllErrors().stream()
        .map((error) -> (new SimpleError((FieldError) error))).collect(Collectors.toList()));
  }
}
