package ru.mirea.pr_11;

public class FunctionalChair implements Chair {
    FunctionalChair() {}

    int sum(int a, int b) {
        return a + b;
    }

    public String toString() {
        return "Функциональный стул..." +
                " стула нет, но хотите сложить" +
                " два числа?";
    }
}
