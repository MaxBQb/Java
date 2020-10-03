package pr_8;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**Implementation of IWaitList, default WaitList
 */
public class WaitList<E> implements IWaitList<E> {
    protected ConcurrentLinkedQueue<E> content;

    /**Create void WaitList
     */
    WaitList() {
         content = new ConcurrentLinkedQueue<E>();
    }

    /**Create WaitList prefilled with elements of collection
     * @param c is collection to be copied
     */
    WaitList(Collection<E> c) {
        this();
        content.addAll(c);
    }

    @Override
    public void add(E element) {
        content.add(element);
    }

    @Override
    public E remove() {
        return content.remove();
    }

    @Override
    public boolean contains(E element) {
        return content.contains(element);
    }

    @Override
    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    @Override
    public boolean isEmpty() {
        return content.isEmpty();
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
