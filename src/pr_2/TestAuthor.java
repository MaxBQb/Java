package pr_2;

public class TestAuthor {
    public static void main(String[] args) {
        var a1 = new pr_2.Author("Ivan Popov", "popov@gmail.com", 'M');
        System.out.println(a1.getGender());
        System.out.println(a1.getName());
        System.out.println(a1);
        a1.setEmail("null@nothing.org");
        System.out.println(a1);
        System.out.println(a1.getEmail());
    }
}
