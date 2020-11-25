package ru.mirea.lab_1;

public class PrintHarmonic {
    public static void main(String[] args) {
        int count = 10;
        for (int i = 1; i <= count; i++) {
            if (i != 1)
                System.out.print(", ");
            System.out.print("1/"+i);
        }
        System.out.println("\nИли");
        for (int i = 1; i <= count; i++) {
            if (i != 1)
                System.out.print(", ");
            System.out.print((1/(double)(i)));
        }
        System.out.println();
    }
}
