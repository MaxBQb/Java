package ru.mirea.pr_2;

public class TestAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Ivan Popov", "popov@gmail.com", 'M');
        System.out.println(a1.getGender());
        System.out.println(a1.getName());
        System.out.println(a1);
        a1.setEmail("null@nothing.org");
        System.out.println(a1);
        System.out.println(a1.getEmail());
    }
}
