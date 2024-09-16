import java.util.ArrayList;
import java.util.List;

class ArrayListMultiSet implements MultiSet {

    private List<Integer> list;

    public ArrayListMultiSet() {
        this.list = new ArrayList<>();
    }
    @Override
    public void add(int item) {
        list.add(item);
    }
    @Override
    public void remove(int item) {
        if (list.contains(item)) {
            list.remove(Integer.valueOf(item));
        }

    }
    @Override
    public boolean contains(int item) {
        return list.contains(item);
    }
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    @Override
    public int count(int item) {
        int count = 0;
        for (int x : list) {
            if (x == item) {
                count++;
            }
        }
        return count;
    }
    @Override
    public int size() {
        return list.size();
    }
}

