package ru.mirea.pr_14;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\t[Завершение ввода Ctrl-D]");
        System.out.println("Введите строки Shirt[]:ru.mirea.pr_14");
        Scanner scanner = new Scanner(System.in);
        String[] dtmp;
        ArrayList<Shirt> arrayList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            dtmp = scanner.nextLine().split(",\\s*");
            Shirt shirt = new Shirt(dtmp[0], dtmp[1], dtmp[2], dtmp[3]);
            arrayList.add(shirt);
        }

        for (int i = 0; i < arrayList.size(); i++) {
            if (i != 0)
                System.out.print(",\n");
            System.out.printf("[%d]: %s",
                    i, arrayList.get(i).toString());
        }
    }
}
/*
S001,Black Polo Shirt,Black,XL
S002, Black Polo Shirt,Black,L
S003,Blue Polo Shirt, Blue,XL
S004,Blue Polo Shirt,Blue,M
S005,Tan Polo Shirt,  Tan,XL
S006,Black T-Shirt,Black,XL
S007,White T-Shirt,White,XL
S008,White T-Shirt,White,L
S009,Green T-Shirt,Green,S
S010,Orange T-Shirt,Orange,S
S011,Maroon Polo Shirt,Maroon,S
*/