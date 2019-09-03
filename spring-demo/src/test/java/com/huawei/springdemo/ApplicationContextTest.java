package com.huawei.springdemo;

import com.huawei.springdemo.beans.Person;
import com.huawei.springdemo.context.ApplicationContext;
import com.huawei.springdemo.context.support.ClassPathXmlApplicationContext;
import com.huawei.springdemo.context.support.FileSystemApplicationContext;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationContextTest {

  @Test
  public void testGetBean() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    Person person = (Person) ctx.getBean("person");
    Assert.assertNotNull(person);
  }

  @Test
  public void testGetBeanFromFileSystemContext() {
    ApplicationContext ctx = new FileSystemApplicationContext("src\\main\\resources\\spring.xml");
    Person person = (Person) ctx.getBean("person");
    Assert.assertNotNull(person);
  }
}
