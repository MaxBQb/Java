package ru.mirea.pr_11;

public class Main {
    public static void main(String[] args) {
        ChairFactory cf = new ChairFactory();
        System.out.println(cf.createFunctionalChair());
        System.out.println("Фунциональный стул сообщает, что 3 + (-3) = " + cf.createFunctionalChair().sum(3, -3));
        Client c = new Client(cf.createVictorianChair());
        c.sit();
        System.out.println(cf.createVictorianChair().getAge()+"!");
        c.sit();
        c.setChair(cf.createMagicalChair());
        c.sit();
        cf.createMagicalChair().doMagic();
    }
}


/*
Реализовать класс Абстрактная фабрика для различных типов стульев:
Викторианский стул, Многофункциональный стул, Магический стул, а также интерфейс Стул,
от которого наследуются все классы стульев, и класс Клиент, который использует интерфейс стул в своем методе Sit (Chair chair).
*/