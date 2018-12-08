package edu.epam.first.creator;

import edu.epam.first.action.QuadrangleAction;
import edu.epam.first.entity.Point;
import edu.epam.first.entity.Quadrangle;
import edu.epam.first.parser.DataParser;
import edu.epam.first.repository.impl.QuadrangleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleCreator {
    private static final Logger logger = LogManager.getLogger();

    public List<Quadrangle> createQuadranglesList(List<String> data) {
        List<Quadrangle> quadrangles = new ArrayList<>();
        QuadrangleAction action = new QuadrangleAction();
        Point firstPoint;
        Point secondPoint;
        Point thirdPoint;
        Point fourthPoint;
        for (String line : data) {
            List<Point> pointsFormLine = createPointsList(line);
            firstPoint = pointsFormLine.get(0);
            secondPoint = pointsFormLine.get(1);
            thirdPoint = pointsFormLine.get(2);
            fourthPoint = pointsFormLine.get(3);
            if (action.isQuadrangle(firstPoint, secondPoint, thirdPoint, fourthPoint)) {
                Quadrangle currentQuadrangle = new Quadrangle(firstPoint, secondPoint, thirdPoint, fourthPoint);
                quadrangles.add(currentQuadrangle);
                QuadrangleRepository.getInstance().add(currentQuadrangle);
            } else {
                logger.error("Create quadrangle error. Isn't quadrangle: " + line);
            }
        }
        return quadrangles;
    }

    private List<Point> createPointsList(String line) {
        DataParser parser = new DataParser();
        List<Point> points = new ArrayList<>();
        List<Double> lineData = parser.parseToDoubleArray(line);
        for (int i = 1; i < lineData.size(); i += 2) {
            points.add(new Point(lineData.get(i - 1), lineData.get(i)));
        }
        return points;
    }
}
