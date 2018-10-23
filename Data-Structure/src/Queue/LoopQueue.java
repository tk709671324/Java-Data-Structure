package Queue;


public class LoopQueue<E> implements Queue<E> {

	private E[] data;
	private int front = 0;
	private int tail = 0;
	private int size = 0;

	public LoopQueue(int capacity) {
		data = (E[]) new Object[capacity + 1];
	}

	public LoopQueue() {
		this(10);
	}

	@Override
	public boolean isEmpty() {
		return front == tail;
	}

	@Override
	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return data.length - 1; // LoopQueue cannot be filled up
	}

	@Override
	public void enqueue(E e) {
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size++;
	}

	@Override
	public E dequeue() {

		if (isEmpty()) {
			System.out.println("Cannot dequeue from an empty queue");
		}
		E ret = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		size--;

		if ((size < getCapacity() / 4) && (getCapacity() != 0)) {
			resize(getCapacity() / 2);
		}
		return ret;

	}

	@Override
	public E front() {
		if (isEmpty()) {
			System.out.println("The queue is empty");
			return null;
		}

		return data[front];
	}

	private void resize(int newCapacity) {

		E[] newData = (E[]) new Object[newCapacity + 1];
		for (int i = 0; i < size; i++) {
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}

	@Override
	public String toString() {

		StringBuilder res = new StringBuilder();
		res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
		res.append("front [");
		for (int i = front; i != tail; i = (i + 1) % data.length) {
			res.append(data[i]);
			if (i != tail - 1)
				res.append(", ");
		}
		res.append("] tail");
		return res.toString();
	}

	public static void main(String[] args) {
		LoopQueue<Integer> queue = new LoopQueue<>();
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
			System.out.println(queue);

			if (i % 3 == 2) {
				queue.dequeue();
				System.out.println(queue);
			}
		}
	}
}
