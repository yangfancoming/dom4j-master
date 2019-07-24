package org.dom4j.goat;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

/**
 * Created by 64274 on 2019/7/24.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/7/24---14:18
 */
public class Demo {


    @Test
    public void test() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("data.xml");
    }

    @Test
    public void secondCreate() throws DocumentException {
        String part = "<u9vip><name>U9VIP</name><title>最实用的原创教程分享论坛</title></u9vip>";
        Document document = DocumentHelper.parseText(part);
    }

}
