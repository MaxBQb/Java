package ru.mirea.pr_11;

public interface AbstractChairFactory {
    VictorianChair createVictorianChair();
    MagicChair createMagicalChair();
    FunctionalChair createFunctionalChair();
}
