package ru.mirea.pr_10;

public class ConcreteFactory implements ComplexAbstractFactory{

    ConcreteFactory() {}

    public Complex createComplex() {
        return new Complex();
    }

    public Complex createComplex(int real, int image) {
        return new Complex(real, image);
    }
}
