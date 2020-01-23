package com.altimetrik.cart.exception;

public class SalesException extends Exception {

  public SalesException(String message) {
    super(message);
  }

  public SalesException(String message, Throwable cause) {
    super(message, cause);
  }

}