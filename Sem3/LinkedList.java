package Sem3;

public class LinkedList {

    public Node head;

    public class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node current = head;
        str.append(current.value).append(", ");
        while (current.next != null) {
            str.append(current.value).append(", ");
            current = current.next;
        }
        return "LinkedList{" + str + "}";

    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + ", ");
            current = current.next;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
        }

    }

    public void addEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void removeEnd() {
        if (head != null) {
            Node current = head;
            while (current.next != null) {
                if (current.next.next == null) {
                    current.next = null;
                    return;
                }
                current = current.next;
            }
            head = null;
        }
    }

    public boolean isContains(int value) {
        return findNode(value) != null ? true : false;
    }

    public Node findNode(int value) {
        while (head != null) {
            if (head.value == value) {
                return head;
            }
            head = head.next;
        }
        return null;
    }
}
