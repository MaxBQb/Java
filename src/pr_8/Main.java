package pr_8;

import java.lang.management.BufferPoolMXBean;

public class Main {
    public static void main(String[] args) {
        BoundedWaitList<Integer> bwl = new BoundedWaitList<Integer>(3);
        UnfairWaitList<Integer> ufwl = new UnfairWaitList<Integer>();

        System.out.println("BoundedWaitList test");
        System.out.println(bwl);
        bwl.add(8);
        bwl.add(9);
        bwl.add(1);
        bwl.add(14);
        System.out.println(bwl);
        System.out.println(bwl.content.poll()); // same package...
        // Differs from C++, okay

        System.out.println("UnfairWaitList test");
        System.out.println(ufwl);
        ufwl.add(1);
        ufwl.add(2);
        ufwl.add(3);
        ufwl.add(4);
        System.out.println(ufwl);
        ufwl.moveToBack(2);
        System.out.println(ufwl);
        ufwl.remove(3);
        ufwl.add(3);
        ufwl.remove(1); // не сработает
        ufwl.moveToBack(1);
        ufwl.add(1);
        System.out.println(ufwl);
        ufwl.remove();
        ufwl.remove();
        ufwl.remove();
        ufwl.remove(1);
        System.out.println(ufwl);
        ufwl.remove();
        System.out.println("Do u think we can't delete first element?");
        System.out.println(ufwl);
        System.out.println("So.. we can :)");

    }
}
