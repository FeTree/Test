package Udemy.DLL;

public class App {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(10);
        list.insertLast(15);
        list.insertLast(12);
        list.display();
        System.out.println("----");
        list.deleteLast();
        list.display();
    }
}
