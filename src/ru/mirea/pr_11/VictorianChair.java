package ru.mirea.pr_11;

public class VictorianChair implements Chair {
    private int age;

    VictorianChair(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    public String toString() {
        return "Викторианский стул," +
                " возрат: " + age;
    }
}
