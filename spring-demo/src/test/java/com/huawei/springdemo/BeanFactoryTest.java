package com.huawei.springdemo;

import com.huawei.springdemo.beans.BeanDefinition;
import com.huawei.springdemo.beans.Person;
import com.huawei.springdemo.beans.PersonTwo;
import com.huawei.springdemo.core.io.ClassPathResource;
import com.huawei.springdemo.factory.BeanCreationException;
import com.huawei.springdemo.factory.BeanDefinitionStoreException;
import com.huawei.springdemo.factory.xml.XmlBeanDefinitionReader;
import com.huawei.springdemo.support.DefaultBeanFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeanFactoryTest {

  private DefaultBeanFactory factory;
  private XmlBeanDefinitionReader reader;

  @Before
  public void setUp() {
    factory = new DefaultBeanFactory();
    reader = new XmlBeanDefinitionReader(factory);
  }

  @Test
  public void testGetBean() {
    reader.loadBeanDefinition(new ClassPathResource("spring.xml"));

    BeanDefinition beanDefinition = factory.getBeanDefinition("person");
    Person person = (Person) factory.getBean("person");
    Assert.assertTrue(beanDefinition.isSingleton());
    Assert.assertFalse(beanDefinition.isPrototype());
    Assert.assertEquals(BeanDefinition.SCOPE_DEFAULT, beanDefinition.getScope());
    Assert.assertEquals("com.huawei.springdemo.beans.Person", beanDefinition.getClassName());

    Person person1 = (Person) factory.getBean("person");
    Assert.assertEquals(person1, person);
  }

  @Test
  public void testInvalidBean() {
    reader.loadBeanDefinition(new ClassPathResource("spring.xml"));
    try {
      factory.getBean("xxx");
    } catch (BeanCreationException e) {
      return;
    }
    Assert.fail("expect BeanCreationException");
  }

  @Test
  public void testInvalidXml() {
    try {
      reader.loadBeanDefinition(new ClassPathResource("xxx.xml"));
    } catch (BeanDefinitionStoreException ex) {
      return;
    }
    Assert.fail("expect BeanDefinitionStoreException");
  }

  @Test
  public void testGetBeanPrototype() {
    reader.loadBeanDefinition(new ClassPathResource("spring.xml"));

    BeanDefinition beanDefinition = factory.getBeanDefinition("personTwo");
    PersonTwo person = (PersonTwo) factory.getBean("personTwo");
    Assert.assertTrue(beanDefinition.isPrototype());
    Assert.assertFalse(beanDefinition.isSingleton());
    Assert.assertEquals(BeanDefinition.SCOPE_PROTOTYPE, beanDefinition.getScope());
    Assert.assertEquals("com.huawei.springdemo.beans.PersonTwo", beanDefinition.getClassName());

    PersonTwo person1 = (PersonTwo) factory.getBean("personTwo");
    Assert.assertNotEquals(person1, person);
  }
}
