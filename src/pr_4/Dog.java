package pr_4;

public class Dog implements Nameable {
    private boolean hasOwner;
    private String name;

    public Dog(String name) {
        this.name = name;
        hasOwner = false;
    }

    public String getName() {
        return "Dog: "+name;
    }

    public boolean hasOwner() {
        return hasOwner;
    }

    public void makeOwn(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }
}
