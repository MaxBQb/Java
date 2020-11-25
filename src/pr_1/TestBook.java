package pr_1;

public class TestBook {
    public static void main(String[] args) {
        Book b = new Book("Гарри Поттер и Методы Рационального мышления",
                          "Элиезер Шломо Юдковский",
                          600);
        System.out.println("Автор "+b.getAuthor()+",");
        System.out.println("написал замечательную книгу "+b.getName()+",");
        System.out.println("примерно на "+b.getPagesCount()+" страниц.");
        System.out.println(b);
    }
}
