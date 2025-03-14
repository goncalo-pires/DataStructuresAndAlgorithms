package DataStructures;

import java.util.StringJoiner;

public class MyDoubleLinkedList<T> {

    public static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> before;
        Node(T value, Node<T> before, Node<T> next) {
            this.value = value;
            this.next = next;
            this.before = before;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public MyDoubleLinkedList(T value) {
        this.head = new Node<>(value, null, null);
        this.tail = this.head;
        this.length = 1;
    }

    public void append(T value) {
        Node<T> newNode = new Node<>(value, this.tail, null);
        this.tail.next = newNode;
        this.tail = newNode;
        this.length++;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value, null, this.head);
        if (this.head != null) {
            this.head.before = newNode;
        }
        this.head = newNode;
        if (this.tail == null) {
            this.tail = newNode;
        }
        this.length++;
    }

    public void remove(int index) {
        if (index < 0 || index >= this.length) return;
        if (index == 0) {
            this.head = this.head.next;
            if (this.head != null) {
                this.head.before = null;
            } else {
                this.tail = null;
            }
        } else {
            Node<T> nodeToRemove = getNode(index);
            Node<T> previousNode = nodeToRemove.before;
            Node<T> nextNode = nodeToRemove.next;

            previousNode.next = nextNode;
            if (nextNode != null) {
                nextNode.before = previousNode;
            } else {
                this.tail = previousNode;
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
            Node<T> nextNode = getNode(index);
            Node<T> previousNode = nextNode.before;
            Node<T> newNode = new Node<>(value, previousNode, nextNode);
            previousNode.next = newNode;
            nextNode.before = newNode;
            this.length++;
        }
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= this.length) return null;
        Node<T> currentNode;
        if (index < this.length / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;
            for (int i = this.length - 1; i >= index; i--) {
                currentNode = currentNode.before;
            }
        }
        return currentNode;
    }

    public void print() {
        StringJoiner stringJoiner = new StringJoiner(" <-> ", "[", "]");
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            stringJoiner.add(currentNode.value.toString());
            currentNode = currentNode.next;
        }
        System.out.println(stringJoiner + " - " + this.length);
    }

    public static void main(String[] args) {
        MyDoubleLinkedList<Integer> myLinkedList = new MyDoubleLinkedList<>(10);
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



