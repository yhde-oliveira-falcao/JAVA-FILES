package shapes;

public class Parallelogram implements Shape {
    private double width;
    private double height;
    private final GetArea area = () -> getHeight() * getWidth();

    @Override
    public double getPerimeter() {
        return (getWidth() + getHeight()) * 2;
    }

    @Override
    public String toString() {
        if (this instanceof Square || this instanceof Rectangle)
            return String.format("%s {w=%s, h=%s} Area = %.5f ",
                    this.getClass().getSimpleName(),
                    this.getWidth(),
                    this.getHeight(), area.getArea());
        else
            return String.format("%s {w=%s, h=%s} ",
                    this.getClass().getSimpleName(),
                    this.getWidth(),
                    this.getHeight());
    }

    public Parallelogram(double w, double h)
            throws ParallelogramException {
        if (w > 0 && h > 0) {
            width = w;
            height = h;
        } else
            throw new ParallelogramException("Invalid side!");
    }

    public void setWidth(double w)
            throws ParallelogramException {
        if (w > 0) {
            width = w;
        } else
            throw new ParallelogramException("Invalid side!");
    }

    public void setHeight(double h) throws ParallelogramException {
        if (h > 0) {
            height = h;
        } else
            throw new ParallelogramException("Invalid side!");
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
