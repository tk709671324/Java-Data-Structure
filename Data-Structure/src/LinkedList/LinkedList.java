package LinkedList;

public class LinkedList<E> {

	// node structure
	private class Node<E>{

		public E e;
		public Node next;

		public Node(E e, Node next){
			this.e = e;
			this.next = next;
		}
		public Node(E e){
			this(e, null);
		}
		public Node(){
			this(null, null);
		}

		@Override
		public String toString() {
			return e.toString();
		}
	}

	//implementation of linkedlist

	private Node dummyHead;
	private int size;

	public LinkedList(){
		dummyHead = new Node();
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void add(int index, E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Invalid index");
		}

		Node prev = dummyHead;
		for(int i = 0; i < index; i++){
			prev = prev.next;
		}

		prev.next = new Node(e, prev.next);
		size++;
	}

	public void addFirst(E e){
		add(0, e);
	}

	public void addLast(E e){
		add(size, e);
	}

	public E get(int index){

		if(index < 0 || index > size){
			throw new IllegalArgumentException("Invalid index");
		}

		Node curr = dummyHead.next;
		for(int i = 0; i < index; i++){
			curr = curr.next;
		}

		return (E)curr.e;
	}

	public E getFirst(){
		return get(0);
	}

	public E getLast(){
		return get(size - 1);
	}

	public void set(int index, E e){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("Invalid index");
		}

		Node curr = dummyHead.next;
		for(int i = 0; i < index; i++){
			curr = curr.next;
		}

		curr.e = e;
	}

	public boolean contains(E e){

		Node curr = dummyHead.next;
		while(curr.next != null){
			if(e.equals(curr.e)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();

		Node curr = dummyHead.next;
		while(curr != null){
			res.append(curr);
			res.append("--> ");
			curr = curr.next;
		}
		res.append("NULL");

		return res.toString();
	}
}
