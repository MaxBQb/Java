package ru.mirea.pr_1;

public class Book {
    private String name;
    private String author;
    private int pages_count;

    public Book(String name, String author, int pages_count) {
        this.name = name;
        this.author = author;
        this.pages_count = pages_count;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPagesCount() {
        return pages_count;
    }

    @Override
    public String toString() {
        return "Книга: \"" +
                name + '"' +
                ", автор: " + author +
                ", " + pages_count +
                " стр.";
    }
}
