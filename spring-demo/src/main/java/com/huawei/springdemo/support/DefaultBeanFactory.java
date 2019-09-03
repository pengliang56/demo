package com.huawei.springdemo.support;

import com.huawei.springdemo.beans.BeanDefinition;
import com.huawei.springdemo.factory.BeanCreationException;
import com.huawei.springdemo.factory.config.ConfigurableBeanFactory;
import com.huawei.springdemo.utils.ClassUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Happyness
 */
public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
    implements ConfigurableBeanFactory,BeanDefinitionRegistry {

  private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
  private ClassLoader beanClassLoader;

  @Override
  public BeanDefinition getBeanDefinition(String beanId) {
    return beanDefinitionMap.get(beanId);
  }

  @Override
  public void registerBeanDefinition(String id, BeanDefinition beanDefinition) {
    beanDefinitionMap.put(id, beanDefinition);
  }

  @Override
  public Object getBean(String beanId) {
    BeanDefinition beanDefinition = getBeanDefinition(beanId);
    if (beanDefinition == null) {
      throw new BeanCreationException("bean definition does not exist");
    }

    if (beanDefinition.isSingleton()) {
      Object bean = getSingleton(beanId);
      if (bean == null) {
        bean = createBean(beanDefinition);
        registerSingleton(beanId, bean);
      }
      return bean;
    }
    return createBean(beanDefinition);
  }

  private Object createBean(BeanDefinition beanDefinition) {
    String beanClassName = beanDefinition.getClassName();
    try {
      Class<?> clz = getBeanClassLoader().loadClass(beanClassName);
      return clz.newInstance();
    } catch (Exception ex) {
      throw new BeanCreationException("create bean for [" + beanClassName + "] failed", ex);
    }
  }

  @Override
  public ClassLoader getBeanClassLoader() {
    return beanClassLoader != null
    ? this.beanClassLoader
    : ClassUtils.getDefaultClassLoader();
  }

  @Override
  public void setBeanClassLoader(ClassLoader beanClassLoader) {
    this.beanClassLoader = beanClassLoader;
  }
}
