package edu.epam.first.creator;

import edu.epam.first.config.FigureConfigurationTest;
import edu.epam.first.entity.Quadrangle;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCreatorTest extends FigureConfigurationTest {

    @Test
    public void testCreateQuadranglesList() {
        List<String> data = new ArrayList<>() {{
            add("1.0 1.0 1.0 2.0 2.0 2.0 2.0 1.0");
        }};
        QuadrangleCreator creator = new QuadrangleCreator();
        List<Quadrangle> actualList = creator.createQuadranglesList(data);
        List<Quadrangle> expectedList = new ArrayList<>() {{
            add(figureData.get("Square"));
        }};
        Assert.assertEquals(actualList, expectedList);
    }
}