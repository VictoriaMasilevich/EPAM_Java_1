package util.epam.first.entity;

public class Point {
    private double X;
    private double Y;

    public Point(double x, double y){
        this.X = x;
        this.Y = y;
    }

    public double getX(){ return X; }

    public double getY(){ return Y; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point point = (Point) obj;
        return Double.compare(point.X, X) == 0 && Double.compare(point.Y, Y) == 0;
    }

    @Override
    public int hashCode(){
        int result = 17;
        result = 31 * result + Double.valueOf(X).hashCode();
        result = 31 * result + Double.valueOf(Y).hashCode();
        return result;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("x = ").append(X).append(", y = ").append(Y);
        return builder.toString();
    }
}
