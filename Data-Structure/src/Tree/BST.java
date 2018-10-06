package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST<E extends Comparable<E>>{

    public class Node{

        public E element;
        public Node left, right;



        public Node(E e){
            this.element = e;
            this.left = null;
            this.right = null;
        }

    }

    private Node root;
    private int size;

    public BST(){
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;

    }

    // add an element to BST
    public void add(E e){
        root = add(this.root, e);
    }

    private Node add(Node root, E e){
        if(root == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(root.element) < 0){
            root.left = add(root.left, e);
        }
        else if (e.compareTo(root.element) > 0){
            root.right = add(root.right, e);
        }

        return root; // if root is not a null , just return itself.
    }





    public boolean contains(E e){
        return contains(this.root, e);
    }

    private boolean contains(Node root, E e){
        if(root == null)
            return false;

        if(e.compareTo(root.element) == 0)
            return true;
        if(e.compareTo(root.element) < 0)
            return contains(root.left, e);
        else
            return contains(root.right, e);

    }

    public void preOrder(){
        preOrder(this.root);
    }

    private void preOrder(Node root){

        if(root == null)
            return;

        System.out.println(root.element);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(){
        inOrder(this.root);
    }

    private void inOrder(Node root){

        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.println(root.element);
        inOrder(root.right);
    }

    public void postOrder(){
        postOrder(this.root);
    }

    public void postOrder(Node root){

        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element);
    }

    public void levelOrder(){
        if (this.root == null){
            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!isEmpty()){
            Node curr = q.remove();
            System.out.println(curr.element);

            if(curr.left != null){
                q.add(curr.left);
            }
            if(curr.right != null){
                q.add(curr.right);
            }
        }
    }

    public E Mininum(){
        return Mininum(this.root).element;
    }
    private Node Mininum(Node root){
        if (root.left == null){
            return root;
        }

        return Mininum(root.left);

    }

    public E Maxinum(){
        return Maxinum(this.root).element;
    }

    public Node Maxinum(Node root){
        if (root == null){
            return root;
        }

        return Maxinum(root.right);
    }


    public E removeMin(){
        E min = Mininum();
        root = removeMin(root);
        return min;
    }

    //remove the mininum node and return the root of the tree
    private Node removeMin(Node root){
        if (root.left == null){
            Node rightChild = root.right;
            root.right = null;
            size --;
            return rightChild;
        }

        root.left = removeMin(root.left);
        return root;
    }

    public E removeMax(){
        E max = Maxinum();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node root){

        if (root.right == null){
            Node leftChild = root.left;
            root.left = null;
            size --;
            return leftChild;
        }

        root.right = removeMax(root.right);
        return root;
    }



    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();

    }

    private void generateBSTString(Node root, int depth, StringBuilder res){
        if(root == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + root.element + "\n");
        generateBSTString(root.left, depth+1, res);
        generateBSTString(root.right, depth+1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++)
            res.append("--");

        return res.toString();
    }


}
