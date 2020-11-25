package ru.mirea.lab_2;

public class Book {
    private String name;
    private String author;
    private int pages_count;
    private int creation_year;

    public Book(String name, String author, int pages_count, int year) {
        this.name = name;
        this.author = author;
        this.pages_count = pages_count;
        creation_year = year;
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

    public int getCreationYear() {
        return creation_year;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Книга: \"" +
                name + '"' +
                ", автор: " + author +
                ", " + pages_count +
                " стр., " + creation_year +
                " год";
    }
}
