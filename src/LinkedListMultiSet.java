
/*
 * <description>
 * @classname   LinkedListMultiSet
 * @params  _front, _size
 * @return
 * @package PACKAGE_NAME
 * @author  Alex Zhang
 * @date   16-Sep.-2024 6:14 p.m.
 * @version 1.0
 */

public class LinkedListMultiSet extends MultiSet {

    private _Node _front;
    private int _size;

    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    public void add(Integer item) {

    }

    /**
     * @param item
     */
    @Override
    public void remove(Integer item) {

    }

    /**
     * @param item
     * @return
     */
    @Override
    public int count(Integer item) {
        return 0;
    }

    /**
     * @param item
     * @return
     */
    @Override
    public boolean contains(Integer item) {
        return false;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * @return
     */
    @Override
    public int size() {
        return 0;
    }
}
