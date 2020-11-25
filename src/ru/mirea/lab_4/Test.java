package ru.mirea.lab_4;

public class Test {
    public static void main(String[] args) {
        Nameable[] creatures = new Nameable[4];
        creatures[0] = new Dog("Belka");
        creatures[1] = new Human("Alex");
        creatures[2] = new Dog("Strelka");
        creatures[3] = new Human("Pavel");

        for (Nameable creature: creatures) {
            System.out.println(creature.getName());
        }
    }
}
