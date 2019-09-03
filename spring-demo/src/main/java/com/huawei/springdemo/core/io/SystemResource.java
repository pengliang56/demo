package com.huawei.springdemo.core.io;

import com.huawei.springdemo.utils.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Happyness
 */
public class SystemResource implements Resource {

  private File file;
  private String path;

  public SystemResource(String path) {
    Assert.notNull(path, "configFile must not be null");
    this.path = path;
    this.file = new File(path);
  }

  @Override
  public InputStream getInputStream() throws IOException {
    return new FileInputStream(file);
  }

  @Override
  public String getDescription() {
    return "path [" + file.getAbsolutePath() + "]";
  }
}
