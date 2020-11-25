package ru.mirea.pr_8;

import java.util.Collection;

/**Interface for waiting list
 * @param <E> type of elements to contain
 */
public interface IWaitList<E> {
    /**Add element in the end of list
     * @param element to be added
     */
    public void add(E element);

    /**Remove element from the end of list
     * @return deleted element or null if no such found
     */
    public E remove();

    /**Check if element is included in list
     * @param element to search
     * @return true if contain such element
     */
    public boolean contains(E element);

    /**Check if elements are included in list
     * @param c is collection to search
     * @return true if contain such elements
     */
    public boolean containsAll(Collection<E> c);

    /**Check if list does not contain any element
     * @return true, if there are no elements in list
     */
    public boolean isEmpty();
}
