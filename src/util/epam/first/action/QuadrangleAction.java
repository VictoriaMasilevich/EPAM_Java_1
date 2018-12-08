package util.epam.first.action;

import util.epam.first.entity.Point;
import util.epam.first.entity.Quadrangle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class QuadrangleAction {
    public double calculatePerimeter(Quadrangle quadrangle) {
        double lengthAB = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointB());
        double lengthBC = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointC());
        double lengthCD = distanceBetweenTwoPoints(quadrangle.getPointC(), quadrangle.getPointD());
        double lengthDA = distanceBetweenTwoPoints(quadrangle.getPointD(), quadrangle.getPointA());
        double perimeter = lengthAB + lengthBC + lengthCD + lengthDA;
        return perimeter;
    }

    /* S^2=(p-a)*(p-b)*(p-c)*(p-d) */
    public double calculateArea(Quadrangle quadrangle) {
        double semiperimeter = calculatePerimeter(quadrangle) / 2;
        double lengthAB = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointB());
        double lengthBC = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointC());
        double lengthCD = distanceBetweenTwoPoints(quadrangle.getPointC(), quadrangle.getPointD());
        double lengthDA = distanceBetweenTwoPoints(quadrangle.getPointD(), quadrangle.getPointA());
        double square = Math.sqrt((semiperimeter - lengthAB) * (semiperimeter - lengthBC) *
                (semiperimeter - lengthCD) * (semiperimeter - lengthDA));
        return square;
    }

    private double distanceBetweenTwoPoints(Point a, Point b) {
        return Math.hypot(a.getX() - b.getX(), a.getY() - b.getY());
    }

    public boolean isQuadrangle(Point a, Point b, Point c, Point d) {
        return (!pointsOnLine(a, b, c) && !pointsOnLine(a, b, d) && !pointsOnLine(b, c, d) && !pointsOnLine(a, d, c));
    }

    private boolean pointsOnLine(Point a, Point b, Point c) {
        return ((a.getX() == b.getX() && b.getX() == c.getX()) ||
                (a.getY() == b.getY() && b.getY() == c.getY()));
    }

    public boolean isConvexQuadrangle(Quadrangle quadrangle) {
        double sumOfAngles = sumOfAngleValues(quadrangle);
        return Double.compare(sumOfAngles, 0) == 0;
    }

    private double sumOfAngleValues(Quadrangle quadrangle) {
        double sum = (angleBetween2Lines(quadrangle.getPointA(), quadrangle.getPointB(), quadrangle.getPointC()) +
                angleBetween2Lines(quadrangle.getPointB(), quadrangle.getPointC(), quadrangle.getPointD()) +
                angleBetween2Lines(quadrangle.getPointC(), quadrangle.getPointD(), quadrangle.getPointA()) +
                angleBetween2Lines(quadrangle.getPointD(), quadrangle.getPointA(), quadrangle.getPointB()));
        return sum;
    }

    private double angleBetween2Lines(Point firstPoint, Point center, Point secondPoint) {
        double angle1 = Math.atan2(center.getY() - firstPoint.getY(),
                center.getX() - firstPoint.getX());
        double angle2 = Math.atan2(center.getY() - secondPoint.getY(),
                center.getX() - secondPoint.getX());
        return angle1 - angle2;
    }

    public boolean isSquare(Quadrangle quadrangle) {
        double lengthAB = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointB());
        double lengthBC = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointC());
        double lengthCD = distanceBetweenTwoPoints(quadrangle.getPointC(), quadrangle.getPointD());
        double lengthDA = distanceBetweenTwoPoints(quadrangle.getPointD(), quadrangle.getPointA());
        double lengthAC = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointC());
        double lengthBD = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointD());
        return ((Double.compare(lengthAB, lengthBC) == 0) &&
                (Double.compare(lengthBC, lengthCD) == 0) &&
                (Double.compare(lengthCD, lengthDA) == 0) &&
                (Double.compare(lengthDA, lengthAB) == 0) &&
                (Double.compare(lengthAC, lengthBD) == 0));
    }

    public boolean isRhomb(Quadrangle quadrangle) {
        double lengthAB = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointB());
        double lengthBC = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointC());
        double lengthCD = distanceBetweenTwoPoints(quadrangle.getPointC(), quadrangle.getPointD());
        double lengthDA = distanceBetweenTwoPoints(quadrangle.getPointD(), quadrangle.getPointA());
        double lengthAC = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointC());
        double lengthBD = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointD());
        return ((Double.compare(lengthAB, lengthBC) == 0) &&
                (Double.compare(lengthBC, lengthCD) == 0) &&
                (Double.compare(lengthCD, lengthDA) == 0) &&
                (Double.compare(lengthDA, lengthAB) == 0) &&
                (Double.compare(lengthAC, lengthBD) != 0));
    }

    public boolean isTrapeze(Quadrangle quadrangle) {
        double lengthAB = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointB());
        double lengthBC = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointC());
        double lengthCD = distanceBetweenTwoPoints(quadrangle.getPointC(), quadrangle.getPointD());
        double lengthDA = distanceBetweenTwoPoints(quadrangle.getPointD(), quadrangle.getPointA());
        double lengthAC = distanceBetweenTwoPoints(quadrangle.getPointA(), quadrangle.getPointC());
        double lengthBD = distanceBetweenTwoPoints(quadrangle.getPointB(), quadrangle.getPointD());
        double firstCondition = new BigDecimal(Math.pow(lengthAC, 2) + Math.pow(lengthBD, 2)).setScale(10,
                RoundingMode.FLOOR).doubleValue();
        double secondCondition = new BigDecimal(2 * lengthAB * lengthCD + Math.pow(lengthBC, 2) +
                Math.pow(lengthDA, 2)).setScale(10, RoundingMode.FLOOR).doubleValue();
        return Double.compare(firstCondition, secondCondition) == 0;
    }
}
