package shapes;

public class Square extends Rectangle{ //A square is a rectangle with equal sides
    @Override
    public void setWidth(double s)
            throws ParallelogramException {
        super.setWidth(s);
        super.setHeight(s);
    }

    @Override
    public void setHeight(double s)
            throws ParallelogramException {
        super.setWidth(s);
        super.setHeight(s);
    }


    public Square(double s)
            throws SquareException,
            ParallelogramException {
        super(s,s);
    }


}
