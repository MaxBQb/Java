package ru.mirea.lab_3;

public class Plate extends Dish {
    protected double inner_radius;
    protected double outer_radius;
    protected double depth;

    public Plate() {
        this(6, 12, 2.5);
    }

    public Plate(double inner_radius, double outer_radius, double depth) {
        super();
        this.inner_radius = inner_radius;
        this.outer_radius = outer_radius;
        this.depth = depth;
    }

    public Plate(String color, double inner_radius, double outer_radius, double depth) {
        super(color);
        this.inner_radius = inner_radius;
        this.outer_radius = outer_radius;
        this.depth = depth;
    }

    public double getInner_radius() {
        return inner_radius;
    }

    public double getOuter_radius() {
        return outer_radius;
    }

    public double getDepth() {
        return depth;
    }

    @Override
    public double getSurfaceArea() {
        return Math.PI*(inner_radius+outer_radius)*
                Math.sqrt(depth*depth+(inner_radius-outer_radius)*(inner_radius-outer_radius));
    }

    @Override
    public String toString() {
        return "Тарелка:\n" +
                "Внутренний радиус: " + inner_radius +
                ", Внешний радиус: " + outer_radius +
                ", Глубина: " + depth +
                ", " + super.toString();
    }
}
