package ru.mirea.pr_10;

public class Main {
    public static void main(String[] args) {
        ConcreteFactory factory = new ConcreteFactory();
        System.out.println(factory.createComplex().getImage());
        System.out.println(factory.createComplex(123,456).getReal());
    }
}
