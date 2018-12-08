package epam.first.config;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

public class DataConfigurationTest {
    public List<String> data;

    @BeforeClass
    public void setUp() {
        data = new ArrayList<>() {{
            add("1.0 2.0F 3.0 4.0 1.0 2.0 3.0 4.0");
            add("1.0 2 3.0 4.0 1.0 2.0 3.0 4.0E10");
            add("1.0 2.0 3.0 4.0 1.0 2.0 3.0 4.0");
            add("1.0 2 3.0 4.0 1.0 2.0 3.0 4.0 5.8");
            add("1.0 2 1.0 4.0 1.0 2.0 3.0 4.0");
            add("1.0 2.z0 3.0 4.0 1.0 2.0 3.0 4.0");
            add("1.0 2.0 3.g0 4.0 1.0 2.0 3.0 4.0");
            add("1 1 2    1 2    2  1    2");
            add("3 7 13 54 8 3 8 5");
            add("1 1 3 3 3 8 1 8");
            add("1 1 1 1 1 1 1 1");
        }};
    }

    @AfterClass
    public void tearDown() {
        data = null;
    }
}
