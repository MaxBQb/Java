package pr_4;

public class Human  implements Nameable {
    private int age;
    private String name;

    public Human(String name) {
        this.name = name;
        age = 0;
    }


    public String getName() {
        return "Human: "+name;
    }

    public int getAge() {
        return age;
    }
}
