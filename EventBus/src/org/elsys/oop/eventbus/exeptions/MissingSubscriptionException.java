package org.elsys.oop.eventbus.exeptions;

public class MissingSubscriptionException extends RuntimeException {
  public MissingSubscriptionException(String message) {
    super(message);
  }
}
