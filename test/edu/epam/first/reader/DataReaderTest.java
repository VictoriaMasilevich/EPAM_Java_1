package edu.epam.first.reader;

import edu.epam.first.config.DataConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DataReaderTest extends DataConfigurationTest {

    @Test
    public void testReadData() {
        String path = "data/input.txt";
        List<String> actualList = DataReader.readData(path);
        List<String> expectedList = data;
        Assert.assertEquals(actualList, expectedList);
    }
}