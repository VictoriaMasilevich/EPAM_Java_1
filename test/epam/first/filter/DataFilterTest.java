package epam.first.filter;

import epam.first.config.DataConfigurationTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.epam.first.filter.DataFilter;

import java.util.ArrayList;
import java.util.List;

public class DataFilterTest extends DataConfigurationTest {

    @Test
    public void testFilterData() {

        DataFilter filter = new DataFilter();
        List<String> actualList = filter.filterData(data);
        List<String> expectedList = new ArrayList<>() {{
            add("1.0 2.0F 3.0 4.0 1.0 2.0 3.0 4.0");
            add("1.0 2 3.0 4.0 1.0 2.0 3.0 4.0E10");
            add("1.0 2.0 3.0 4.0 1.0 2.0 3.0 4.0");
            add("1.0 2 1.0 4.0 1.0 2.0 3.0 4.0");
            add("1 1 2    1 2    2  1    2");
            add("3 7 13 54 8 3 8 5");
            add("1 1 3 3 3 8 1 8");
            add("1 1 1 1 1 1 1 1");
        }};
        Assert.assertEquals(actualList, expectedList);

    }
}