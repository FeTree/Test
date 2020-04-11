package Udemy.SLL;

import java.util.ArrayList;

public class SinglyLinkedList {
     Node first;

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int data){
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int data){
        Node current = first;
        while(current.next != null){
            current = current.next;
        }
        Node newNode = new Node();
        newNode.data = data;
        current.next = newNode;
    }

    public Node deleteFirst(){
        Node temp = first;
        first = first.next;
        return temp;
    }

    public void displayList(){
        System.out.println("List (first --> last");
        Node current = first;
        while(current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    public Node reverseList(){
        Node current = first;
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

    public int findMin() {
        Node current = first;
        int min = Integer.MAX_VALUE;
        while (current != null) {
            if (min > current.data) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    //assume not last node
    public Node deleteWhere(int key, Node head){
        Node current = head;
        while(current.next != null){
            if(current.next.data == key){
                current.next = current.next.next;
            }
            current = current.next;
        }
        return current;
    }

    public Node deleteLast(Node head){
        Node current = head;
        while(current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return current;
    }

    //https://practiceit.cs.washington.edu/problem/view/bjp5/chapter16/e6-hasTwoConsecutive
    //Write a method hasTwoConsecutive that returns whether or not a list of integers has two adjacent
    // numbers that are consecutive integers (true if such a pair exists and false otherwise).
    public boolean hasTwoConsecutive(Node head) {
        Node current = head;
        while(current.next != null){
            if(current.data == ((current.next.data) + 1)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Write a method switchPairs that switches the order of elements in a linked list of integers in a pairwise fashion
    public void switchPairs(Node head){
        Node current = head;
        Node prev;
        while(current.next != null){
            prev = current;
            current.next = current;
            prev = current.next;
            current = current.next; //traverse list
        }
    }

    //Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
    public Node mergeTwoLists(Node l1){
        ArrayList<Integer> al = new ArrayList<>();

        Node currentl1 = l1;
        while(l1.next != null) {
            al.add(l1.data);
            l1 = l1.next;
        }
        Node current = null;
        for (int i = 0; i < al.size() ; i++) {
            System.out.println(al.get(i));
        }

        return current;
    }

}//end class
