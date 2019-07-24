

package org.dom4j.datatype;

import org.dom4j.DocumentFactory;
import org.dom4j.io.SAXReader;
import org.testng.annotations.BeforeClass;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

/**
 * Test harness to test the various data types supported in the XML Schema Data
 * Type integration.
 * 
 * @author <a href="mailto:jstrachan@apache.org">James Strachan </a>
 * @version $Revision: 1.4 $
 */
public class DataTypesTest extends AbstractDataTypeTestCase {

    public void testgMonthDay() throws Exception {
        testNodes("//gMonthDayTag", Calendar.class);
    }

    public void testgDay() throws Exception {
        testNodes("//gDayTag", Calendar.class);
    }

    public void testgMonth() throws Exception {
        testNodes("//gMonthTag", Calendar.class);
    }

    public void testDate() throws Exception {
        testNodes("//dateTag", Calendar.class);
    }

    public void testTime() throws Exception {
        testNodes("//timeTag", Calendar.class);
    }

    public void testDateTime() throws Exception {
        testNodes("//dateTimeTag", Calendar.class);
    }

    public void testgYearMonth() throws Exception {
        testNodes("//gYearMonthTag", Calendar.class);
    }

    public void testgYear() throws Exception {
        testNodes("//gYearTag", Calendar.class);
    }

    public void testBoolean() throws Exception {
        testNodes("//booleanTag", Boolean.class);
    }

    public void testBase64Binary() throws Exception {
        testNodes("//base64BinaryTag", byte[].class);
    }

    public void testHexBinary() throws Exception {
        testNodes("//hexBinaryTag", byte[].class);
    }

    // Number types
    public void testFloat() throws Exception {
        testNodes("//floatTag", Float.class);
    }

    public void testDouble() throws Exception {
        testNodes("//doubleTag", Double.class);
    }

    public void testDecimal() throws Exception {
        testNodes("//decimalTag", BigDecimal.class);
    }

    public void testInteger() throws Exception {
        testNodes("//integerTag", BigInteger.class);
    }

    public void testNonPositiveInteger() throws Exception {
        testNodes("//nonPositiveIntegerTag", BigInteger.class);
    }

    public void testNegativeInteger() throws Exception {
        testNodes("//negativeIntegerTag", BigInteger.class);
    }

    public void testLong() throws Exception {
        testNodes("//longTag", Long.class);
    }

    public void testInt() throws Exception {
        testNodes("//intTag", Integer.class);
    }

    public void testShort() throws Exception {
        testNodes("//shortTag", Short.class);
    }

    public void testByte() throws Exception {
        testNodes("//byteTag", Byte.class);
    }

    public void testNonNegativeInteger() throws Exception {
        testNodes("//nonNegativeIntegerTag", BigInteger.class);
    }

    public void testUnsignedLong() throws Exception {
        testNodes("//unsignedLongTag", BigInteger.class);
    }

    public void testUnsignedInt() throws Exception {
        testNodes("//unsignedIntTag", Long.class);
    }

    public void testUnsignedShort() throws Exception {
        testNodes("//unsignedShortTag", Integer.class);
    }

    public void testUnsignedByte() throws Exception {
        testNodes("//unsignedByteTag", Short.class);
    }

    public void testPositiveInteger() throws Exception {
        testNodes("//positiveIntegerTag", BigInteger.class);
    }

    // Implementation methods
    // -------------------------------------------------------------------------
    @BeforeClass
    public void setUp() throws Exception {
        super.setUp();

        DocumentFactory factory = DatatypeDocumentFactory.getInstance();
        SAXReader reader = new SAXReader(factory);
        document = getDocument("/xml/test/schema/test.xml", reader);
    }
}

