package ru.mirea.lab_2;

public class BookTest {
    public static void main(String[] args) {
        Book b = new Book("Гарри Поттер и Методы Рационального мышления",
                          "Элиезер Шломо Юдковский",
                          600, 2015);
        System.out.println("Автор "+b.getAuthor()+",");
        System.out.println("в "+b.getCreationYear()+" году,");
        System.out.println("написал замечательную книгу "+b.getName()+",");
        System.out.println("примерно на "+b.getPagesCount()+" страниц.");
        System.out.println(b);
        b.setName("Harry Potter and the Methods of Rationality");
        System.out.println(b);
    }
}
