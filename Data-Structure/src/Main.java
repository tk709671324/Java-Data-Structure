
import Arrays.Array;
import Tree.BST;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BST<Integer> BTree = new BST<>();
        BTree.add(123);
        BTree.add(1);
        BTree.add(44412);
        BTree.add(1231);
        BTree.add(2354);
        BTree.add(145);
        BTree.add(5345);
        BTree.inOrder();
}
}
