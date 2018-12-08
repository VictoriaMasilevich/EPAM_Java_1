package edu.epam.first.entity;

public class Quadrangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Quadrangle(Point A, Point B, Point C, Point D){
        this.pointA = A;
        this.pointB = B;
        this.pointC = C;
        this.pointD = D;
    }

    public Point getPointA(){ return pointA; }

    public void setPointA(Point A) {
        pointA = A;
    }

    public Point getPointB(){ return pointB; }

    public void setPointB(Point B) {
        pointB = B;
    }

    public Point getPointC(){ return pointC; }

    public void setPointC(Point C) {
        pointC = C;
    }

    public Point getPointD(){ return pointD; }

    public void setPointD(Point D) {
        pointD = D;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) { return true; }
        if (obj == null || getClass() != obj.getClass()) return false;
        Quadrangle quadrangle = (Quadrangle) obj;
        return  pointA.equals(quadrangle.pointA) &&
                pointB.equals(quadrangle.pointB) &&
                pointC.equals(quadrangle.pointC) &&
                pointD.equals(quadrangle.pointD);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + pointA.hashCode();
        result = 31 * result + pointB.hashCode();
        result = 31 * result + pointC.hashCode();
        result = 31 * result + pointD.hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(", point A: ").append(pointA)
                .append(", point B: ").append(pointB)
                .append(", point C: ").append(pointC)
                .append(", point D: ").append(pointD);
        return builder.toString();
    }
}
