
import Arrays.Array;
import LinkedList.LinkedList;
import Tree.BST;

public class Main {

    public static void main(String[] args) {
	// write your code here
       LinkedList<Integer> linkedList = new LinkedList<>();

       for(int i = 1; i < 6; i++){
           linkedList.addFirst(i);
           System.out.println(linkedList);
       }

       linkedList.add(4, 666);
       System.out.println(linkedList);
}
}
