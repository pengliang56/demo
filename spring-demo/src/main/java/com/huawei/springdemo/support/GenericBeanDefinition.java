package com.huawei.springdemo.support;

import com.huawei.springdemo.beans.BeanDefinition;

/**
 * @author Happyness
 */
public class GenericBeanDefinition implements BeanDefinition {

  private String id;

  private String beanClassName;

  private String scope = SCOPE_DEFAULT;

  private boolean singleton = true;

  private boolean prototype = false;

  public GenericBeanDefinition(String id, String beanClassName) {
    this.id = id;
    this.beanClassName = beanClassName;
  }

  @Override
  public String getClassName() {
    return beanClassName;
  }

  @Override
  public Boolean isSingleton() {
    return singleton;
  }

  @Override
  public Boolean isPrototype() {
    return prototype;
  }

  @Override
  public String getScope() {
    return scope;
  }

  @Override
  public void setScope(String scope) {
    this.scope = scope;
    this.singleton = SCOPE_SINGLETON.equals(scope) || SCOPE_DEFAULT.equals(scope);
    this.prototype = SCOPE_PROTOTYPE.endsWith(scope);
  }
}
