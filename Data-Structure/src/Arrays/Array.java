package Arrays;

public class Array {

    private int[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 50;


    public Array(int capacity){
        this.data = new int[capacity];
    }

    public Array(){
        this(DEFAULT_CAPACITY);
    }

    public void add(int index, int element){

        if(size == data.length){
            throw new IllegalArgumentException("fail to add, the array is full");
        }
        if((index < 0) || (index > size)){
            throw new IllegalArgumentException("invalid index");
        }

        for(int i = size - 1; i >= index; i--){
            data[i+1] = data[i];
        }

        data[index] = element;
        size ++;

    }

    public void addFirst(int element){
        add(0, element);
    }

    public void addLast(int element){
        add(size, element);
    }

    public int get(int index){

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

    public void set(int index, int element){

        if(size == data.length){
            throw new IllegalArgumentException("fail to add, the array is full");
        }
        data[index] = element;
    }

    public boolean contains(int element){
        for (int i = 0; i < size; i++){
            if(data[i] == element)
                return true;
        }
        return false;
    }

    public int find(int element){
        for (int i = 0; i < size; i++){
            if(data[i] == element)
                return i;
        }
        return -1;
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

}
