package ru.mirea.pr_8;

public class BoundedWaitList<E> extends WaitList<E> {
    private final int capacity;

    /**Create BoundedWaitList with strictly set of capacity
     * @param capacity of new BoundedWaitList
     */
    BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }

    /**Get capacity value
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**Add element in the end of list (unless it exceed capacity)
     * @param element to be added
     */
    @Override
    public void add(E element) {
        if (content.size()+1 <= capacity)
            super.add(element);
    }

    @Override
    public String toString() {
        // if I'll write same, but with ' '
        // it'll evaluate as capacity + 32 (I'm confused)
        return capacity + " " + super.toString();
    }
}
