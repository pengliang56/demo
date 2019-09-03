package com.huawei.springdemo.factory.config;

/**
 * @author Happyness
 */
public interface SingletonBeanRegistry {

  /**
   * register bean
   * @param beanName bean name {@link String}
   * @param singletonObject singleton object {@link Object}
   */
  void registerSingleton(String beanName, Object singletonObject);

  /**
   * get singleton bean
   * @param beanName {@link String} bean id
   * @return {@link Object}
   */
  Object getSingleton(String beanName);
}
