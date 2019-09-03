package com.huawei.springdemo.factory;

import com.huawei.springdemo.beans.BeansException;

/**
 * @author Happyness
 */
public class BeanDefinitionStoreException extends BeansException {

  public BeanDefinitionStoreException(String msg, Throwable cause) {
    super(msg, cause);
  }
}
