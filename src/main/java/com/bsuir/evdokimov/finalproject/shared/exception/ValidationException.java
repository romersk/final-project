package com.bsuir.evdokimov.finalproject.shared.exception;

import java.util.List;

public class ValidationException extends AbstractException {

  private List<com.bsuir.evdokimov.finalproject.shared.validation.Error> errorList;

  public ValidationException(String message) {
    super(message);
  }

  public ValidationException(List<com.bsuir.evdokimov.finalproject.shared.validation.Error> errorList) {
    super("");
    this.errorList = errorList;
  }

  public List<com.bsuir.evdokimov.finalproject.shared.validation.Error> getErrorList() {
    return errorList;
  }
}
