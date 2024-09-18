/**
 * Abstract class representing a MultiSet ADT.
 */
public abstract class MultiSet {

    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */

    public abstract void add(Integer item);

    public abstract void remove(Integer item);

    public abstract int count(Integer item);

    public abstract boolean contains(Integer item);

    public abstract boolean isEmpty();

    public abstract int size();
}
