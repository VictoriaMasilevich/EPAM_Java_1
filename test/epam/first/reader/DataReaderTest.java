package epam.first.reader;

import epam.first.config.DataConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.epam.first.reader.DataReader;

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