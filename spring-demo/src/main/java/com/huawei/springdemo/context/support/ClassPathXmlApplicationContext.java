package com.huawei.springdemo.context.support;

import com.huawei.springdemo.core.io.ClassPathResource;
import com.huawei.springdemo.core.io.Resource;

/**
 * @author Happyness
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

  public ClassPathXmlApplicationContext(String configFile) {
    super(configFile);
  }

  @Override
  protected Resource getResourceByPath(String path) {
    return new ClassPathResource(path, getBeanClassLoader());
  }
}
