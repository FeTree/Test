package Udemy.DLL;

public class DoublyLinkedList {
    Node first = null;
    Node last = null;

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
//        if(first == null){
//            first = newNode;
//        }
        newNode.next = first;
        first = newNode;
        newNode.prev = first;
    }

    public void insertLast(int data){
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
        newNode.prev = current;
        last = newNode;
    }

    public Node deleteFirst(){
        Node current = first;
        first = first.next;
        first.next.prev = first;
        return current;
    }

    public Node deleteLast(){
        Node current = first;
        while(current.next.next != null){
            current = current.next;
        }

        current.next = null;
        return current;
    }

    public void display(){
        Node current = first;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
