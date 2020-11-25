package ru.mirea.pr_11;

public class MagicChair implements Chair {
    MagicChair() {}

    void doMagic() {
        System.out.println("Скидка 5% пенсионерам, по субботам до 13:00");
    }

    public String toString() {
        return "Обычный стул... но стоит как магический...";
    }
}
