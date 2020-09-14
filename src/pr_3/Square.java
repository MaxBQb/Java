package pr_3;

public class Square extends Rectangle {
    public Square() {
        this(1);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return length;
    }

    public void setSide(double side) {
        length = side;
        width = side;
    }

    public void setLength(double side) {
       setSide(side);
    }

    public void setWidth(double side) {
       setSide(side);
    }

    public String toString() {
        return "Square{" +
                "side=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
