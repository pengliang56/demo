package com.huawei.springdemo.context.support;

import com.huawei.springdemo.context.ApplicationContext;
import com.huawei.springdemo.core.io.Resource;
import com.huawei.springdemo.factory.xml.XmlBeanDefinitionReader;
import com.huawei.springdemo.support.DefaultBeanFactory;
import com.huawei.springdemo.utils.ClassUtils;

/**
 * @author Happyness
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

  private DefaultBeanFactory factory;
  private ClassLoader beanClassLoader;

  public AbstractApplicationContext(String configFile) {
    factory = new DefaultBeanFactory();
    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
    Resource resource = getResourceByPath(configFile);
    reader.loadBeanDefinition(resource);
    factory.setBeanClassLoader(getBeanClassLoader());
  }

  @Override
  public Object getBean(String beanId) {
    return factory.getBean(beanId);
  }

  /**
   * Template method
   * @param configFile
   * @return {@link Resource}
   */
  protected abstract Resource getResourceByPath(String configFile);

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
