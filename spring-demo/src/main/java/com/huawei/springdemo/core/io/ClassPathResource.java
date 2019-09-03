package com.huawei.springdemo.core.io;

import com.huawei.springdemo.utils.ClassUtils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Happyness
 */
public class ClassPathResource implements Resource {

  private String configFile;
  private ClassLoader classLoader;

  public ClassPathResource(String configFile) {
    this(configFile, null);
  }

  public ClassPathResource(String configFile, ClassLoader classLoader) {
    this.configFile = configFile;
    this.classLoader = (classLoader != null
    ? classLoader
    : ClassUtils.getDefaultClassLoader());
  }

  @Override
  public InputStream getInputStream() throws IOException {
    InputStream is = classLoader.getResourceAsStream(configFile);
    if (is == null) {
      throw new FileNotFoundException(configFile + " cannot be opened");
    }
    return is;
  }

  @Override
  public String getDescription() {
    return configFile;
  }
}
