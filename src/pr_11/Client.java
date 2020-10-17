package pr_11;

public class Client {
    public Chair chair;
    protected boolean sitting;

    Client(Chair chair) {
        this.chair = chair;
    }

    void sit() {
        if (sitting) {
            System.out.println("Клиент продолжает сидеть на стуле...");
            return;
        }
        sitting = true;
        System.out.println("Клиент присел на стул:");
        System.out.println(chair);
    }

    void setChair(Chair chair) {
        this.chair = chair;
        sitting = false;
        System.out.println("Из под клиента выбили стул...");
        System.out.println("В качестве извенений, поставили рядом другой");
    }
}
