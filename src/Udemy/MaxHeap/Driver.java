package Udemy.MaxHeap;

public class Driver {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.insert(10);
        heap.insert(14);
        heap.insert(25);
        heap.insert(24);
        heap.insert(88);
        heap.insert(1);

        heap.displayHeap();
    }
}
