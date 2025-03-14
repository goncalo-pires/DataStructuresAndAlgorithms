package DataStructures;

import java.util.StringJoiner;
import Utils.Node;

public class MyQueue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size;

    public MyQueue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public T peek() {
        if (this.first == null) return null;
        return this.first.value;
    }

    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (this.last == null) {
            this.first = newNode;
        } else{
            this.last.next = newNode;
        }
        this.last = newNode;
        this.size++;
    }

    public T dequeue() {
        if (this.first == null) return null;
        Node<T> nodeToRemove = this.first;
        this.first = this.first.next;
        if (this.first == null) {
            this.last = null;
        }
        this.size--;
        return nodeToRemove.value;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        StringJoiner stringJoiner = new StringJoiner(" -> ", "[", "]");
        Node<T> currentNode = this.first;
        while (currentNode != null) {
            stringJoiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }
        System.out.println(stringJoiner);
    }

    public static void main(String[] args) {
        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.enqueue("value1");
        myQueue.enqueue("value2");
        myQueue.print();
        String peek = myQueue.peek();
        System.out.println("Peek: " + peek);
        String dequeue = myQueue.dequeue();
        System.out.println("Dequeue: " + dequeue);
        myQueue.print();
    }
}
