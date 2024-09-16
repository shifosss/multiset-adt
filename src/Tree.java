import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tree {
    private Integer root = null;
    private List<Tree> subtrees;

    public Tree(Integer root, ArrayList<Tree> subtrees) {
        this.root = root;
        if (subtrees == null) {
            this.subtrees = new ArrayList<>();
        } else {
            this.subtrees = subtrees;
        }
    }
    // TODO complete this Tree class to replicate the implementation from the Tree class in adts.py
    public boolean is_empty() {
        return this.root == null;
    }

    public int __len__() {
        if (this.is_empty()) {
            return 0;
        }
        else {
            int size = 1;
            for (Tree subtree : this.subtrees) {
                size += subtree.__len__();
            }
            return size;
        }
    }

    public int count(int item) {
        if (this.is_empty()) {
            return 0;
        }
        else {
            int num = 0;
            if (this.root == item) {
                num += 1;
            }
            for (Tree subtree : this.subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }

    public String __str__() {
        return this.str_indented(0);
    }

    private String str_indented(int depth) {
        if (this.is_empty()) {
            return "";
        }
        else {
            String s = "  ".repeat(depth) + (this.root.toString()) + '\n';
            for (Tree subtree : this.subtrees) {
                s += subtree.str_indented(depth + 1);
            }
            return s;
        }
    }

    public double average() {
        if (this.is_empty()) {
            return 0.0;
        }
        else {
            int total = this.average_helper().get(0);
            int count = this.average_helper().get(1);
            return (double) total / count;
        }
    }

    private List<Integer> average_helper() {
        if (this.is_empty()) {
            List<Integer> lst = Arrays.asList(0,0);
            return lst;
        }
        else {
            int total = this.root;
            int size = 1;
            for (Tree subtree : this.subtrees) {
                int subtree_total = subtree.average_helper().get(0);
                int subtree_size = subtree.average_helper().get(1);
                total += subtree_total;
                size += subtree_size;
            }
            return Arrays.asList(total,size);
        }
    }

    public boolean __eq__(Tree other) {
        if (this.is_empty() && other.is_empty()) {
            return true;
        }
        else if (this.is_empty() || other.is_empty()) {
            return false;
        }
        else {
            if (this.root != other.root) {
                return false;
            }
            if (this.subtrees.size() != other.subtrees.size()) {
                return false;
            }
            return this.subtrees == other.subtrees;
        }
    }

    public boolean __contains__(int item) {
        if (this.is_empty()) {
            return false;
        }
        if (this.root == item) {
            return true;
        }
        else {
            for (Tree subtree : this.subtrees) {
                if (subtree.__contains__(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    public List<Integer> leaves() {
        if (this.is_empty()) {
            return new ArrayList<>();
        }
        else if (this.subtrees.size() == 0) {
            return Arrays.asList(this.root);
        }
        else {
            List<Integer> leaves = new ArrayList<>();
            for (Tree subtree : this.subtrees) {
                leaves.addAll(subtree.leaves());
            }
            return leaves;
        }
    }

    public void insert(int item) {
        if (this.is_empty()) {
            this.root = item;
        }
        else if (this.subtrees.size() == 0) {
            this.subtrees = new ArrayList<>();
            this.subtrees.add(new Tree(item, new ArrayList<>()));
        }
        else {
            Random rd = new Random();
            if (rd.nextInt(3) + 1 == 3) {
                this.subtrees.add(new Tree(item, new ArrayList<>()));
            }
            else {
                int subtree_index = rd.nextInt(0, this.subtrees.size() - 1);
                this.subtrees.get(subtree_index).insert(item);
            }
        }
    }
}
