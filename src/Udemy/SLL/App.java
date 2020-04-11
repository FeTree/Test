package Udemy.SLL;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertFirst(100);
        list.insertLast(50);
        list.insertLast(51);
        list.insertLast(1);
        list.insertLast(69);
        list.displayList();
    }

    public static int listLength(Node aNode){
        int length = 0;
        Node current = aNode;
        while(current != null){
            length++;
            current = current.next;
        }
        return length;
    }

    public static Node reverseList(Node head){
        Node current = head;
        Node prev = null;
        Node nextTemp = null;
        while(current != null){
            nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public static boolean isSorted(SinglyLinkedList list){
        boolean flag = true;
        Node current = list.first;
        int firstData = list.first.data;
        while(current.next != null) {
            if (firstData > current.next.data) {
                flag = false;
            }
            current = current.next;
        }
        return flag;
    }

    public Node middleNode(Node head) {
        ArrayList<Node> list = new ArrayList<>();
        Node current = head;

        int i = 0;
        while (current.next != null){
            list.add(current);
        }

        int middle = list.size() / 2;

        return current;
    }



}
