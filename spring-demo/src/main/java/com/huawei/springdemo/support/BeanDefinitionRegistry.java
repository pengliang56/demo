package com.huawei.springdemo.support;

import com.huawei.springdemo.beans.BeanDefinition;

/**
 * @author Happyness
 */
public interface BeanDefinitionRegistry {

  /**
   * get bean definition
   * @param beanId bean id
   * @return {@link BeanDefinition}
   */
  BeanDefinition getBeanDefinition(String beanId);

  /**
   * registry bean Definition
   * @param id bean id
   * @param beanDefinition {@link BeanDefinition} bean is a definition
   */
  void registerBeanDefinition(String id, BeanDefinition beanDefinition);
}
