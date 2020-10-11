package pr_10;

public class Complex {
    private int real;
    private int image;

    Complex() {
        this(0,0);
    }

    Complex(int real, int image) {
        this.real = real;
        this.image = image;
    }

    public int getReal() {
        return real;
    }

    public int getImage() {
        return image;
    }
}
