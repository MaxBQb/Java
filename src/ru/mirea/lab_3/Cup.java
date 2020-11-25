package ru.mirea.lab_3;

public class Cup extends Dish {
    protected double radius;
    protected double height;

    public Cup() {
        this(4, 8);
    }

    public Cup(double radius, double height) {
        super();
        this.radius = radius;
        this.height = height;
    }

    public Cup(String color, double radius, double height) {
        super(color);
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double getSurfaceArea() {
        return 2*radius*radius*Math.PI + 4*radius*Math.PI*height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Стакан:\nВысота: " + height + ", Радиус: " + radius + ",\n" + super.toString();
    }
}
