package epam.first.validator;

import org.testng.Assert;
import org.testng.annotations.Test;
import util.epam.first.validator.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {

    @Test
    public void testIsValidPointsCountPositive() {
        List<String> line = new ArrayList<>() {{
            add("1.0");
            add("2.0");
            add("3.0");
            add("4.0");
            add("5.0");
            add("6.0");
            add("7.0");
            add("8.0");
        }};
        boolean actual = DataValidator.isValidPointsCount(line);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void testIsValidPointsCountNegative() {
        List<String> line = new ArrayList<>() {{
            add("1.0");
            add("2.0");
            add("3.0");
            add("4.0");
            add("5.0");
            add("6.0");
            add("7.0");
            add("8.0");
            add("9.0");
        }};
        boolean actual = DataValidator.isValidPointsCount(line);
        boolean expected = true;
        Assert.assertNotEquals(actual, expected);
    }

    @Test
    public void testIsValidDoubleDataPositive() {
        List<String> line = new ArrayList<>() {{
            add("1.0");
            add("2.0F");
            add("3.0f");
            add("4.0D");
            add("5.0d");
            add("6.0E10");
            add("7");
            add("8.0");
        }};
        boolean actual = DataValidator.isValidDoubleData(line);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsValidDoubleDataNegative() {
        List<String> line = new ArrayList<>() {{
            add("1.0");
            add("x");
            add("3.0f");
            add("4.0D");
            add("5.0d");
            add("6.0E10");
            add("7");
            add("8.0");
        }};
        boolean actual = DataValidator.isValidDoubleData(line);
        boolean expected = true;
        Assert.assertNotEquals(actual, expected);
    }
}