package com.huawei.springdemo.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Happyness
 */
public interface Resource {


  /**
   * get a InputStream Object
   * @return {@link InputStream}
   * @throws IOException not file configFile {@link FileNotFoundException}
   */
  InputStream getInputStream() throws IOException;

  /**
   * get a resource description
   * @return {@link String} return a resource description
   */
  String getDescription();
}
