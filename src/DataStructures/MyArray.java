package DataStructures;

import java.util.Arrays;

public class MyArray {

    private Object[] data;
    private int size;
    private int capacity;

    MyArray() {
        this.capacity = 10;
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void print() {
        Object[] usedData = Arrays.copyOfRange(this.data, 0, this.size);
        System.out.println(Arrays.toString(usedData));
    }

    public Object get(int index) {
        if (index < 0 || index >= size ) {
            return null;
        }
        return data[index];
    }

    public void push(Object obj) {
        if (capacity <= size) {
            resize();
        }
        this.data[size++] = obj;
    }

    public Object pop() {
        Object obj = this.data[this.size-1];
        this.data[this.size-1] = null;
        this.size--;
        return obj;
    }

    private void delete(int index) {
        if (index >= 0 && index < size) {
            shiftLeft(index);
        }
    }

    private void resize() {
        this.capacity = this.capacity*2;
        this.data = Arrays.copyOf(this.data, this.capacity);
    }

    private void shiftLeft(int index) {
        for (int i=index; i<size-1; i++) {
            this.data[i] = this.data[i+1];
        }
        this.data[size-1] = null;
        size--;
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray();

        myArray.push(1);
        myArray.push(2);
        myArray.push(3);

        myArray.print();

        System.out.println(myArray.get(0));
        System.out.println(myArray.get(-2));
        System.out.println(myArray.get(123));
        System.out.println(myArray.get(2));

        myArray.print();

        System.out.println(myArray.pop());

        myArray.print();

        myArray.delete(1);

        myArray.print();


    }
}

