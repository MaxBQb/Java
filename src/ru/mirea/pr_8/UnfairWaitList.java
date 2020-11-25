package ru.mirea.pr_8;

import java.util.HashSet;

public class UnfairWaitList<E> extends WaitList<E> {
    private HashSet<E> blacklist;

    /**Create void UnfairWaitList
     */
    UnfairWaitList() {
        super();
        blacklist = new HashSet<E>();
    }

    /**Remove first entry element
     * @param element to be removed
     */
    public void remove(E element) {
        int i = 0;
        for (E iter: content) {
            if (iter == element) {
                if (i != 0) {
                    content.remove(iter);
                    blacklist.add(element);
                }
                return;
            }
            i++;
        }
    }

    /**Add element in the end of list (if only it hasn't removed before)
     * @param element to be added
     */
    @Override
    public void add(E element) {
        if (!blacklist.contains(element))
            super.add(element);
    }

    /**Move first entry element to the end of list
     * @param element to be moved
     */
    public void moveToBack(E element) {
        for (E iter: content)
            if (iter == element) {
                content.remove(iter);
                content.add(element);
                return;
            }
    }
}
