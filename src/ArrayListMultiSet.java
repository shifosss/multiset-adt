
/*
 * <description>
 * @classname   ArrayListMultiSet
 * @params
 * @return
 * @package PACKAGE_NAME
 * @author  Alex Zhang
 * @date   17-Sep.-2024 12:37 a.m.
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayListMultiSet extends MultiSet {

    private List<Integer> list;

    public ArrayListMultiSet() {
        list = new ArrayList<>();
    }

    @Override
    public void add(Integer item) {
        list.add(item);
    }

    @Override
    public void remove(Integer item) {
        if (list.contains(item)) {
            list.remove(Integer.valueOf(item));
        }

    }

    @Override
    public boolean contains(Integer item) {
        return list.contains(item);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int count(Integer item) {
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
