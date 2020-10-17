package pr_11;

public class ChairFactory implements AbstractChairFactory {

    public VictorianChair createVictorianChair() {
        return new VictorianChair(321);
    }

    public MagicChair createMagicalChair() {
        return new MagicChair();
    }

    public FunctionalChair createFunctionalChair() {
        return new FunctionalChair();
    }
}
