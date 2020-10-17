package pr_13;

public class Add implements IValue {
    private IValue a;
    private IValue b;

    public Add(IValue a, IValue b) {
        this.a = a;
        this.b = b;
    }

    public int evaluate(int x) {
        return a.evaluate(x) + b.evaluate(x);
    }
}
