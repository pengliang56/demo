package com.huawei.springdemo.factory;

/**
 * @author Happyness
 */
public interface BeanFactory {

  /**
   * get the bean
   * @param beanId in line with object id get object
   * @return return the object
   */
  Object getBean(String beanId);
}
