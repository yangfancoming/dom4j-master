

package org.dom4j.bean;

import org.dom4j.AbstractTestCase;
import org.dom4j.Document;
import org.dom4j.io.SAXReader;


public class BeansTest extends AbstractTestCase {

    public void testReadXML() throws Exception {
        SAXReader reader = new SAXReader(BeanDocumentFactory.getInstance());
        Document document = getDocument("/xml/bean/gui.xml", reader);
        System.out.println("tesng-------"+document);
    }
}

