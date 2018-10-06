package Arrays;

public class Array<E> {

    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 50;


    public Array(int capacity){
        this.data = (E[])new Object[capacity];
    }

    public Array(){
        this(DEFAULT_CAPACITY);
    }

    public void add(int index, E element){


        if((index < 0) || (index > size)){
            throw new IllegalArgumentException("invalid index");
        }
        if(size == data.length){
            resize(2 * data.length);
        }

        for(int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }

        data[index] = element;
        size ++;

    }

    public void addFirst(E element){
        add(0, element);
    }

    public void addLast(E element){
        add(size, element);
    }

    public E get(int index){

        if(size == data.length){
            throw new IllegalArgumentException("fail to add, the array is full");
        }
        return data[index];
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize(){
        return size;
    }

    public void set(int index, E element){

        if(size == data.length){
            throw new IllegalArgumentException("fail to add, the array is full");
        }
        data[index] = element;
    }

    public boolean contains(E element){
        for (int i = 0; i < size; i++){
            if(data[i].equals(element))
                return true;
        }
        return false;
    }

    public int find(E element){
        for (int i = 0; i < size; i++){
            if(data[i].equals(element))
                return i;
        }
        return -1;
    }

    public E delete(int index){

        if((index < 0) || (index > size)){
            throw new IllegalArgumentException("invalid index");
        }


        E ret = data[index];

        for (int i = index  ; i < size - 1 ; i++){
            data[i] = data[i+1];
        }


        size--;
        data[size] = null;

        if((size == (data.length / 4)) && (data.length / 2 != 0))       //in case of vibration
            resize(data.length / 2);

        return ret;
    }

    public E deleteFirst(){
        return delete(0);
    }

    public E deleteLast(){
        return delete(size - 1);
    }
    public void deleteElement(E element){

        int index = find(element);
        if(index != -1){
            delete(index);
        }
    }

    public boolean isEmpty(){
        return (size == 0);
    }
    @Override
    public String toString(){

        StringBuilder result = new StringBuilder();
        result.append(String.format("Array:\nSize = %d, Capacity = %d\n", size, data.length));
        result.append("[");
        for(int i = 0;i < size;i++){
            result.append(data[i]);
            if(i != size - 1)
                result.append(", ");
        }
        result.append("]");

        return result.toString();
    }


    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];

        data = newData;
    }

}
