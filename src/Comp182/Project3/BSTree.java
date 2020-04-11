/*
Author: David Eisenbaum
Comp 182
Professor Barnes
Project 3
 */
package Comp182.Project3;

import Udemy.binarySearchTree.BST;

public class BSTree <E extends Comparable<E>>{

    private BSTNode<E> root;


    public void setRoot(BSTNode<E> newRoot){
        this.root = newRoot;
    }

    public BSTNode<E> insert(BSTNode<E> node, BSTNode<E> newNode){
        if(node == null) return newNode;
        if(node.compareTo(newNode) > 0){
            node.setLeft(insert(node.getLeft(), newNode));
        }
        else node.setRight(insert(node.getRight(), newNode));
        return node;
    }

    public BSTNode<E> delete(BSTNode<E> node, BSTNode<E> target){
        if(node == null) return null; //not found
        //find the target
        if(node.compareTo(target)> 0) { //node.key > target key
            node.setLeft(delete(node.getLeft(), target));
        }
        else if(node.compareTo(target)> 0){
            node.setRight(delete(node.getRight(), target));
        }
        else{ //found target
            //only right child
            if(node.getLeft() == null) return node.getRight();
            else{ //2 children
                BSTNode<E> temp = getMinR(node.getRight());
                node = temp;
                node.setRight(deleteMinR(node.getRight()));
            }
        }
        return node;
    }

    BSTNode<E> getMinR(BSTNode<E> node){
        if(node.getLeft() == null) return node;
        return getMinR(node.getLeft());
    }

    BSTNode<E> deleteMinR(BSTNode<E> node){
        if(node.getLeft() == null) return node.getRight();
        node.setLeft(deleteMinR(node.getLeft()));
        return node;
    }

    public int height(BSTNode node)
    {
        if (node == null)
            return 0;
        else
        {
            int lDepth = height(node.getLeft());
            int rDepth = height(node.getRight());

            if (lDepth > rDepth)
                return lDepth + 1;
            else
                return rDepth + 1;
        }
    }

    public BSTNode<E> getRoot() {
        return root;
    }

    public void inOrderTraverse(BSTNode<E> root){
        if(root == null) return;
        if(root.getLeft() != null){
            inOrderTraverse(root.getLeft());
        }
        System.out.println(root.getE().toString());
        if(root.getRight() != null){
            inOrderTraverse(root.getRight());
        }
    }

    public BSTNode removeHalfNodes(BSTNode node)
    {
        if (node == null)
            return null;

        node.setLeft(removeHalfNodes(node.getLeft()));
        node.setRight(removeHalfNodes(node.getRight()));

        if (node.getLeft() == null && node.getRight() == null)
            return node;


        if (node.getLeft() == null)
        {
            BSTNode new_root = node.getRight();
            return new_root;
        }

        if (node.getRight() == null)
        {
            BSTNode new_root = node.getLeft();
            return new_root;
        }

        return node;
    }

//    public void nodeLevel(Sample s){
//        int level = height(getRoot());
//        s.add(level);
//    }

    public boolean verify() {
        return true;
    }

} //end class
