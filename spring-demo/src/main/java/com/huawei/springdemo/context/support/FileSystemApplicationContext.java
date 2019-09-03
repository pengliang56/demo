package com.huawei.springdemo.context.support;

import com.huawei.springdemo.core.io.Resource;
import com.huawei.springdemo.core.io.SystemResource;

/**
 * @author Happyness
 */
public class FileSystemApplicationContext extends AbstractApplicationContext{

  public FileSystemApplicationContext(String configFile) {
    super(configFile);
  }

  @Override
  protected Resource getResourceByPath(String configFile) {
    return new SystemResource(configFile);
  }
}
