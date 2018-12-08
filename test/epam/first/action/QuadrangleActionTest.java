package epam.first.action;

import epam.first.config.FigureConfigurationTest;
import util.epam.first.action.QuadrangleAction;
import util.epam.first.entity.Quadrangle;

import org.testng.Assert;
import org.testng.annotations.Test;

public class QuadrangleActionTest extends FigureConfigurationTest{
    @Test
    public void testCalculateArea() {
        QuadrangleAction action = new QuadrangleAction();
        Quadrangle square = figureData.get("Square");
        double actual = action.calculateArea(square);
        double expected = 1.0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testCalculatePerimeter() {
        QuadrangleAction action = new QuadrangleAction();
        Quadrangle square = figureData.get("Square");
        double actual = action.calculatePerimeter(square);
        double expected = 4.0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsQuadrangle() {
        QuadrangleAction action = new QuadrangleAction();
        Quadrangle square = figureData.get("Square");
        boolean actual = action.isQuadrangle(square.getPointA(), square.getPointB(),
                square.getPointC(), square.getPointD());
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsConvexQuadrangle() {
        QuadrangleAction action = new QuadrangleAction();
        Quadrangle square = figureData.get("Square");
        boolean actual = action.isConvexQuadrangle(square);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsSquare() {
        QuadrangleAction action = new QuadrangleAction();
        Quadrangle square = figureData.get("Square");
        boolean actual = action.isSquare(square);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsRhomb() {
        QuadrangleAction action = new QuadrangleAction();
        Quadrangle rhomb = figureData.get("Rhomb");
        boolean actual = action.isRhomb(rhomb);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testIsTrapeze() {
        QuadrangleAction action = new QuadrangleAction();
        Quadrangle trapeze = figureData.get("Trapeze");
        boolean actual = action.isTrapeze(trapeze);
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }
}