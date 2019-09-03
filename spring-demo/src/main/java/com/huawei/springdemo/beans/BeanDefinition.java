package com.huawei.springdemo.beans;

/**
 * @author Happyness
 */
public interface BeanDefinition {

  String SCOPE_SINGLETON = "singleton";

  String SCOPE_PROTOTYPE = "prototype";

  String SCOPE_DEFAULT = "";

  /**
   * get class name
   * @return the class name, type is the {@link String}
   */
  String getClassName();

  /**
   * check bean is singleton ?
   * @return {@link Boolean}
   */
  Boolean isSingleton();

  /**
   * check bean is prototype ?
   * @return {@link Boolean}
   */
  Boolean isPrototype();

  /**
   * get bean definition scope
   * @return {@link String}
   */
  String getScope();

  /**
   * set bean definition scope
   * @param scope {@link String} scope
   */
  void setScope(String scope);
}
