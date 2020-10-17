package pr_13;

public class Multiply implements IValue {
    private IValue a;
    private IValue b;

    public Multiply(IValue a, IValue b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate(int x) {
        return a.evaluate(x) * b.evaluate(x);
    }
}
