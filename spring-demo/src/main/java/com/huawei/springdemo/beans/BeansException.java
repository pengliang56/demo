package com.huawei.springdemo.beans;

/**
 * @author Happyness
 */
public class BeansException extends RuntimeException {

  public BeansException(String msg) {
    super(msg);
  }

  public BeansException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
