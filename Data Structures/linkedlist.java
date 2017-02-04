import java.io.*;

class LinkedList {
    private Node head;
    private int length;

    LinkedList () {}

    public static void main(String[] argv) {
        LinkedList linkedList = new LinkedList();

        linkedList.addNodeToTheBack(1);
        linkedList.addNodeToTheBack(2);
        linkedList.addNodeToTheBack(3);
        linkedList.addNodeToTheBack(4);
        linkedList.addNodeToTheBack(5);
        linkedList.addNodeToTheBack(6);

        linkedList.print();
    }

    void addNodeToTheBack(Object value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(value));
        }
    }

    void print() {
        Node currentNode = head;

        while (currentNode.getNext() != null) {
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }
}

class Node {
    Node next;
    Object data;

    public Node (Object data) {
        this.data = data;
    }

    public Node(Object data, Node next) {
        this.next = next;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}