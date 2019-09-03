package com.huawei.springdemo;

import com.huawei.springdemo.core.io.ClassPathResource;
import com.huawei.springdemo.core.io.Resource;
import com.huawei.springdemo.core.io.SystemResource;
import java.io.IOException;
import java.io.InputStream;
import org.junit.Assert;
import org.junit.Test;

public class ResourceTest {

  @Test
  public void testClassPathResource() throws IOException {
    Resource resource = new ClassPathResource("spring.xml");

    InputStream in = null;
    try {
      in = resource.getInputStream();
      Assert.assertNotNull(in);
    } finally {
      if (in != null) {
          in.close();
      }
    }
  }

  @Test
  public void testFileSystemResource() throws IOException {
    Resource resource = new SystemResource("src\\main\\resources\\spring.xml");

    InputStream in = null;
    try {
      in = resource.getInputStream();
      Assert.assertNotNull(in);
    } finally {
      if (in != null) {
        in.close();
      }
    }
  }
}
