import java.util.*;

public class Tree {
    private Integer root = null;
    private ArrayList<Tree> subtrees;

    public Tree(Integer root, ArrayList<Tree> subtrees) {
        this.root = root;
        this.subtrees = Objects.requireNonNullElseGet(subtrees, ArrayList::new);
    }

    public Tree() {
        this.root = null;
        this.subtrees = new ArrayList<>();
    }

    public boolean is_empty() {
        return this.root == null;
    }

    public int __len__() {
        if (this.is_empty()) {
            return 0;
        } else {
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
        } else {
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
        } else {
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
        } else {
            int total = this.average_helper().get(0);
            int count = this.average_helper().get(1);
            return (double) total / count;
        }
    }

    private List<Integer> average_helper() {
        if (this.is_empty()) {
            List<Integer> lst = Arrays.asList(0, 0);
            return lst;
        } else {
            int total = this.root;
            int size = 1;
            for (Tree subtree : this.subtrees) {
                int subtree_total = subtree.average_helper().get(0);
                int subtree_size = subtree.average_helper().get(1);
                total += subtree_total;
                size += subtree_size;
            }
            return Arrays.asList(total, size);
        }
    }

    public boolean __eq__(Tree other) {
        if (this.is_empty() && other.is_empty()) {
            return true;
        } else if (this.is_empty() || other.is_empty()) {
            return false;
        } else {
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
        } else {
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
        } else if (this.subtrees.size() == 0) {
            return Arrays.asList(this.root);
        } else {
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
        } else if (this.subtrees.size() == 0) {
            this.subtrees = new ArrayList<>();
            this.subtrees.add(new Tree(item, new ArrayList<>()));
        } else {
            Random rd = new Random();
            if (rd.nextInt(3) + 1 == 3) {
                this.subtrees.add(new Tree(item, new ArrayList<>()));
            } else {
                int subtree_index = rd.nextInt(0, this.subtrees.size() - 1);
                this.subtrees.get(subtree_index).insert(item);
            }
        }
    }

    public boolean delete_item(int item) {
        if (this.is_empty()) {
            return false;
        } else if (this.root == item) {
            this.delete_root();
            return true;
        } else {
            for (Tree subtree : this.subtrees) {
                boolean deleted = subtree.delete_item(item);
                if (deleted && subtree.is_empty()) {
                    this.subtrees.remove(subtree);
                    return true;
                } else if (deleted) {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        }
    }

    private void delete_root() {
        if (this.subtrees == null) {
            this.root = null;
        } else {
            Tree chosen_subtree = this.subtrees.remove(this.subtrees.size() - 1);
            this.root = chosen_subtree.root;
            this.subtrees.addAll(chosen_subtree.subtrees);
        }
    }

    private int extract_leaf() {
        if (this.subtrees == null) {
            int old_root = this.root;
            this.root = null;
            return old_root;
        } else {
            int leaf = this.subtrees.get(0).extract_leaf();
            if (this.subtrees.get(0).is_empty()) {
                this.subtrees.remove(this.subtrees.size() - 1);
            }
            return leaf;
        }
    }

    public boolean insert_child(int item, int parent) {
        if (this.is_empty()) {
            return false;
        } else if (this.root == parent) {
            this.subtrees.add(new Tree(item, null));
            return true;
        } else {
            for (Tree subtree : this.subtrees) {
                if (subtree.insert_child(item, parent)) {
                    return true;
                }
            }
            return false;
        }
    }
}
