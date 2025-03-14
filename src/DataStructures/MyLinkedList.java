package DataStructures;

import Utils.Node;

import java.util.StringJoiner;

public class MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public MyLinkedList(T value) {
        this.head = new Node<>(value, null);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value, null);
        if (this.tail == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.length++;
    }

    public void prepend(T value) {
        this.head = new Node<>(value, head);
        if (this.tail == null) {
            this.tail = this.head;
        }
        this.length++;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.length) return;
        if (this.head == null) return;
        if (index == 0) {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
        } else {
            Node<T> previousNode = getNode(index - 1);
            if (index == this.length - 1) {
                previousNode.next = null;
                this.tail = previousNode;
            } else {
                previousNode.next = previousNode.next.next;
            }
        }
        this.length--;
    }

    public void insert(int index, T value) {
        if (index <= 0 ) {
            this.prepend(value);
        } else if (index >= this.length) {
            this.append(value);
        } else {
            Node<T> previousNode = getNode(index - 1);
            previousNode.next = new Node<>(value, previousNode.next);
            this.length++;
        }
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= this.length) return null;
        Node<T> currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }


    public void print() {
        StringJoiner stringJoiner = new StringJoiner(" -> ", "[", "]");
        Node currentNode = this.head;
        while (currentNode != null) {
            stringJoiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }
        System.out.println(stringJoiner + " - " + this.length);
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>(10);
        myLinkedList.append(5);
        myLinkedList.append(51);
        myLinkedList.print();
        myLinkedList.prepend(2);
        myLinkedList.print();
        myLinkedList.insert(5, 24);
        myLinkedList.print();
        myLinkedList.insert(0, 26);
        myLinkedList.print();
        myLinkedList.insert(2, 28);
        myLinkedList.print();
        myLinkedList.remove(0);
        myLinkedList.print();
        myLinkedList.remove(2);
        myLinkedList.print();
        myLinkedList.remove(123);
        myLinkedList.print();
    }

}



