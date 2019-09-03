package com.huawei.springdemo.factory.config;

import com.huawei.springdemo.factory.BeanFactory;

/**
 * @author Happyness
 */
public interface ConfigurableBeanFactory extends BeanFactory {

  /**
   * get {@link ClassLoader}
   * @return {@link ClassLoader}
   */
  ClassLoader getBeanClassLoader();

  /**
   * Configurable set classLoader
   * @param classLoader {@link ClassLoader} Configurable
   */
  void setBeanClassLoader(ClassLoader classLoader);
}
