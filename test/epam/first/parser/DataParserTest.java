package epam.first.parser;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.epam.first.parser.DataParser;

import java.util.ArrayList;
import java.util.List;

public class DataParserTest {
    DataParser parser;

    @BeforeClass
    public void setUp() {
        parser = new DataParser();
    }

    @Test
    public void testParseToDoubleArray() {
        String data = "1.0 2.0d 3.0 4.0 1.0 2.0 3.0 4.0";
        List<Double> actualList = parser.parseToDoubleArray(data);
        List<Double> expectedList = new ArrayList<>() {{
            add(1.0);
            add(2.0d);
            add(3.0);
            add(4.0);
            add(1.0);
            add(2.0);
            add(3.0);
            add(4.0);
        }};
        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testParseToStringArray() {
        String data = "1.0 2.0d        3.0 4.0      1.0                  2.0 3.0 4.0";
        List<String> actualList = parser.parseToStringArray(data);
        List<String> expectedList = new ArrayList<>() {{
            add("1.0");
            add("2.0d");
            add("3.0");
            add("4.0");
            add("1.0");
            add("2.0");
            add("3.0");
            add("4.0");
        }};
        Assert.assertEquals(actualList, expectedList);
    }

    @AfterClass
    public void tearDown() {
        parser = null;
    }
}