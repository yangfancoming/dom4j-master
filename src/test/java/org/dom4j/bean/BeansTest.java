

package org.dom4j.bean;

import org.dom4j.AbstractTestCase;
import org.dom4j.io.SAXReader;

/**
 * DOCUMENT ME!
 * 
 * @author <a href="mailto:maartenc@users.sourceforge.net">Maarten Coene </a>
 */
public class BeansTest extends AbstractTestCase {

    public void testReadXML() throws Exception {
        SAXReader reader = new SAXReader(BeanDocumentFactory.getInstance());
        getDocument("/xml/bean/gui.xml", reader);
    }
}

