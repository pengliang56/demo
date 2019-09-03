package com.huawei.springdemo.factory.xml;

import com.huawei.springdemo.beans.BeanDefinition;
import com.huawei.springdemo.core.io.Resource;
import com.huawei.springdemo.factory.BeanDefinitionStoreException;
import com.huawei.springdemo.support.BeanDefinitionRegistry;
import com.huawei.springdemo.support.GenericBeanDefinition;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author Happyness
 */
public class XmlBeanDefinitionReader {

  private static final String ID_ATTRIBUTE = "id";

  private static final String CLASS_ATTRIBUTE = "class";

  private static final String SCOPE_ATTRIBUTE = "scope";

  private BeanDefinitionRegistry registry;

  public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
    this.registry = registry;
  }

  public void loadBeanDefinition(Resource resource) {
    InputStream in = null;
    try {
      in = resource.getInputStream();
      SAXReader sax = new SAXReader();
      Document doc = sax.read(in);
      Element rootElement = doc.getRootElement();
      Iterator iter = rootElement.elementIterator();
      while (iter.hasNext()) {
        Element ele = (Element) iter.next();
        String id = ele.attributeValue(ID_ATTRIBUTE);
        String beanClassName = ele.attributeValue(CLASS_ATTRIBUTE);
        BeanDefinition beanDefinition = new GenericBeanDefinition(id, beanClassName);
        if (ele.attributeValue(SCOPE_ATTRIBUTE) != null) {
          beanDefinition.setScope(ele.attributeValue(SCOPE_ATTRIBUTE));
        }
        registry.registerBeanDefinition(id, beanDefinition);
      }
    } catch (Exception ex) {
      throw new BeanDefinitionStoreException("IOException parsing XML document fail", ex);
    } finally {
      if (in != null) {
        try {
          in.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
