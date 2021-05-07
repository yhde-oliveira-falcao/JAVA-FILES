package shapes;

public class Circle implements Shape {
    private double radius;
    private final GetArea circleArea = () -> Math.PI * getRadius() * getRadius();
    @Override
    public double getPerimeter() {
        return (getRadius() * 2) * Math.PI;
    }


    @Override
    public String toString() {
        return String.format("%s {r=%s} Area : %.5f ",this.getClass().getSimpleName(), this.getRadius(),circleArea.getArea());
    }

    public Circle(double r)
            throws CircleException {
        if(r > 0) {
            radius = r;
        } else
            throw new CircleException("Invalid radius!");
    }

    public void setRadius(double r)
            throws CircleException {
        if(r > 0) {
            radius = r;
        } else
            throw new CircleException("Invalid radius!");
    }

    public double getRadius() {
        return radius;
    }
}
