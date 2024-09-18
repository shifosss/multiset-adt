import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static void profileMultiSet(MultiSet my_input, int n) {

        List<Integer> items_added = new ArrayList<>();
        Random rd = new Random();

        for (int i = 0; i < n; i++){
            int x = rd.nextInt(0, 100);
            my_input.add(x);
            items_added.add(x);
        }

    // sanity check that we added n items
        assert my_input.size() == n;

        double start = System.currentTimeMillis() / 1000.0;

        for (int x : items_added){
            my_input.remove(x);
        }

        double end = System.currentTimeMillis() / 1000.0;

    // sanity check that we successfully removed all the items we had added!
        assert my_input.isEmpty();

    // just print a quick summary of what we just ran
        System.out.printf("%5d ", n);
        System.out.print(my_input.getClass());
        System.out.printf(" %.6f\n", end - start);
    }

    public static void main(String[] args) {
        // import doctest
        // doctest.testmod()

        // we won't bother running pyTA for this :)
        // import python_ta
        // python_ta.check_all(config={'extra-imports': ['random']})

        // perform a little timing experiment
        int[] testcase = new int[]{500, 1000, 2000, 4000};
        TreeMultiSet tree_multiset = new TreeMultiSet();
        ArrayListMultiSet array_list_multiset = new ArrayListMultiSet();
        LinkedListMultiSet link_list_multiset = new LinkedListMultiSet();
        List<MultiSet> multisets = new ArrayList<MultiSet>();
        multisets.add(tree_multiset);
        multisets.add(array_list_multiset);
        multisets.add(link_list_multiset);
        for (MultiSet multiset : multisets){
            for (int n : testcase){
                profileMultiSet(multiset, n);
            }
        }

    }
}
