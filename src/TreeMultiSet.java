public class TreeMultiSet extends MultiSet {

    private Tree _tree;

    public TreeMultiSet() {
        _tree = new Tree();
    }

    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    @Override
    public void add(Integer item) {
        _tree.insert(item);
    }

    /**
     * Remove the given item from this multiset
     *
     * @param item item to remove
     */
    @Override
    public void remove(Integer item) {
        _tree.delete_item(item);
    }

    /**
     * Count the number of occurrence of the given item in this multiset
     *
     * @param item item to count
     * @return number of occurrence
     */
    @Override
    public int count(Integer item) {
        return _tree.count(item);
    }

    /**
     * Check if given item is contained in this multiset
     *
     * @param item item to check
     * @return condition of containing
     */
    @Override
    public boolean contains(Integer item) {
        return _tree.__contains__(item);
    }

    /**
     * Check if this multiset is empty
     *
     * @return status of emptiness
     */
    @Override
    public boolean isEmpty() {
        return _tree.is_empty();
    }

    /**
     * Calculate the size of this multiset
     *
     * @return the size
     */
    @Override
    public int size() {
        return _tree.__len__();
    }
}
