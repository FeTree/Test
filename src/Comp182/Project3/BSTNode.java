/*
Author: David Eisenbaum
Comp 182
Professor Barnes
Project 3
 */
package Comp182.Project3;

public class BSTNode <E extends Comparable<E>> {
    private BSTNode<E> leftChild, rightChild;
    private Integer key;
    private E element;

    public BSTNode(E anE){
        leftChild = null;
        rightChild = null;
        element = anE;
    }

    public E getE(){
        return element;
    }

    public Integer getKey() {
        return key;
    }

    public BSTNode<E> getLeft() {
        return leftChild;
    }

    public BSTNode<E> getRight() {
        return rightChild;
    }

    public void setLeft(BSTNode<E> left){
        this.leftChild = left;
    }

    public void setRight(BSTNode<E> right){
        this.rightChild = right;
    }

    public int compareTo(BSTNode<E> other){
        return element.compareTo(other.getE());
    }


}
