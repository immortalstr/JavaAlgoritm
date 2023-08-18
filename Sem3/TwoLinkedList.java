package Sem3;

public class TwoLinkedList {
    public Node head;
    public Node tail;

    public class Node {
        public int value;
        public Node next;
        public Node previous;

        public Node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node node = head;
        str.append(node.value).append(", ");
        while (node.next != null) {
            str.append(node.value).append(", ");
            node = node.next;
        }
        return "LinkedList{" + str + "}";

    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value + ", ");
            node = node.next;
        }
    }

    public void addFirst(int value) {
        Node node = new Node(value);
        if (head != null) {
            node.next = head;
            head.previous = node;
        } else {
            tail = node;
        }
        head = node;

    }

    public void deleteFirst() {
        if (head != null && head.previous != null) {
            head.next.previous = null;
            head = head.next;
        } else {
            head = null;
            tail = null;

        }
    }

    public void addEnd(int value) {
        Node node = new Node(value);
        if (tail == null) {
            tail = node;
        } else {
            Node node = tail;
            tail.next = node;
            node.previous = node;
        }
        tail = node;
    }

    public void removeEnd() {
        if (tail != null && tail.previous != null) {
            tail.previous.next = null;
            tail = tail.previous;
        } else {
            head = null;
            tail = null;
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

    public void sort(){
    boolean flag;
    do{
        flag = false;
        Node node = head;
        while(node != null && node.next != null){
            if(node.value > node.next.value){
                Node before = node.previous;
                Node after = node.next.next;
                Node current = node;
                Node next = node.next;

                current.next = after;
                current.previous = next;
                next.next = current;
                next.previous = before;

                if(before != null){
                    before.next = next;

                }else{
                    head =next;
                }
                if (after!= null){
                    after.previous = current;
                }else{
                    tail = current;
                
                }
                flag = true; 
            }
            node = node.next;
        }
    }while(flag);
}
}
