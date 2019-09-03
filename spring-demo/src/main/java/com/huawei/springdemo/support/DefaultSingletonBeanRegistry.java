package com.huawei.springdemo.support;

import com.huawei.springdemo.factory.config.SingletonBeanRegistry;
import com.huawei.springdemo.utils.Assert;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Happyness
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

  private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>(64);

  @Override
  public void registerSingleton(String beanName, Object singletonObject) {
    Assert.notNull(beanName, "'beanName' must not be bull");

    Object oldObject = getSingleton(beanName);
    if (oldObject != null) {
      throw new IllegalStateException("cloud not register object [" + singletonObject +
          "] under bean name '" + beanName + "': there is already object [" + oldObject + "]");
    }
    singletonObjects.put(beanName, singletonObject);
  }

  @Override
  public Object getSingleton(String beanName) {
    return singletonObjects.get(beanName);
  }
}
