package ru.mirea.lab_3;

public class Test {
    public static void main(String[] args) {
        Dish c = new Cup();

        System.out.println("// Cup ---");
        System.out.println(((Cup)c).getHeight());
        System.out.println(((Cup)c).getRadius());
        System.out.println(c.getSurfaceArea());
        System.out.println(c);
        c.Brake();
        System.out.println((Cup)c);
        System.out.println(c.getFaryAmount());
        System.out.println(c.getShardsCount());

        Dish p = new Plate();

        System.out.println("// Plate ---");
        System.out.println(((Plate)p).getDepth());
        System.out.println(((Plate)p).getInner_radius());
        System.out.println(((Plate)p).getOuter_radius());
        System.out.println(((Plate)p).getColor());
        System.out.println(p.getSurfaceArea());
        System.out.println(p);
        ((Plate)p).Brake();
        p.setColor("Чёрный");
        System.out.println(p);
        ((Plate)p).clear();
        System.out.println(p);
    }
}
