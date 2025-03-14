package DataStructures;

import java.util.StringJoiner;
import Utils.Node;

public class MyStack<T> {

    private Node<T> top;
    private int size;

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    public T peek() {
        if (this.top == null) return null;
        return this.top.value;
    }

    public void push(T value) {
        this.top = new Node<>(value, this.top);
        this.size++;
    }

    public T pop() {
        if (this.top == null) return null;
        Node<T> nodeToRemove = this.top;
        this.top = nodeToRemove.next;
        this.size--;
        return nodeToRemove.value;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        StringJoiner stringJoiner = new StringJoiner(" -> ", "[", "]");
        Node<T> currentNode = this.top;
        while (currentNode != null) {
            stringJoiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }
        System.out.println(stringJoiner);
    }

    public static void main(String[] args) {
        MyStack<String> myStack = new MyStack<>();
        myStack.push("value1");
        myStack.push("value2");
        myStack.print();
        System.out.println(myStack.peek());
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.pop());
        myStack.print();
    }
}
