package epam.first.config;

import util.epam.first.entity.Point;
import util.epam.first.entity.Quadrangle;
import util.epam.first.repository.impl.QuadrangleRepository;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;

public class FigureConfigurationTest {
    public Map<String, Quadrangle> figureData = new HashMap<>();

    @BeforeClass
    public void setUp() {
        figureData.put("Square", new Quadrangle(new Point(1, 1), new Point(1, 2),
                new Point(2, 2), new Point(2, 1)));
        figureData.put("Trapeze", new Quadrangle(new Point(1, 1), new Point(4, 1),
                new Point(3, 3), new Point(2, 3)));
        figureData.put("Rhomb", new Quadrangle(new Point(4, 5), new Point(6, 0),
                new Point(8, 5), new Point(6, 10)));
        figureData.put("Quadrangle", new Quadrangle(new Point(1, 1), new Point(3, 3),
                new Point(2, 5), new Point(1, 4)));

        QuadrangleRepository.getInstance().add(figureData.get("Rhomb"));
        QuadrangleRepository.getInstance().add(figureData.get("Square"));
        QuadrangleRepository.getInstance().add(figureData.get("Trapeze"));
    }

    @AfterClass
    public void tearDown() {
        QuadrangleRepository.getInstance().removeAll();
    }

}
