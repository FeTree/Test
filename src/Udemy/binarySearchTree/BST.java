package Udemy.binarySearchTree;


import java.util.ArrayList;
import java.util.HashSet;

public class BST {

    Node root;

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.val)
            root.left = insertRec(root.left, key);
        else if (key > root.val)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    public Node findMin(){
        Node current = root;
        Node last = null;

        while(current != null){
            last = current;
            current = current.left;
        }
        return last;
    }


    public Node findMax(){
        Node current = root;
        Node last = null;

        while(current != null){
            last = current;
            current = current.right;
        }
        return last;
    }

    public boolean remove(int val){

        Node currentNode = root;
        Node parentNode = root;

        boolean isleft = false;

        //searching to find node with val to delete
        while(currentNode.val != val){
            parentNode = currentNode;
            if(val < currentNode.val){
                isleft = true;
                currentNode = currentNode.left;
            }
            else{
                currentNode = currentNode.right;
                isleft = false;
            }
            if(currentNode == null){
                return false; //couldnt find val
            }
        }
        //found node
        Node nodeToDelete = currentNode;

        // if node is a leaf (no children)
        if(nodeToDelete.left == null && nodeToDelete.right == null){
            //
            if (nodeToDelete == root) {
                root = null;
            } else if (isleft) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        }
        // if node has a child on left
        else if(nodeToDelete.right == null){
            if(nodeToDelete == root){
                root = nodeToDelete.left;
            }
            else if(isleft){
                parentNode.left = nodeToDelete.left;
            }
            else{
                parentNode.right = nodeToDelete.left;
            }
        }
        // if node has a child on right
        else if(nodeToDelete.left == null){
            if(nodeToDelete == root){
                root = nodeToDelete.right;
            }
            else if(isleft){
                parentNode.left = nodeToDelete.right;
            }
            else{
                parentNode.right = nodeToDelete.right;
            }
        }

        // if node has 2 children (hardest)
        else{

            Node successor = getSuccessor(nodeToDelete);

            //connect parent of nodeToDelete to succesor instead
            if(nodeToDelete == root){
                root = successor;
            }
            else if(isleft){
                parentNode.left = successor;
            }
            else{
                parentNode.right = successor;
            }
            successor.left = nodeToDelete.left; //replace
        }
        return true;
    }

    private Node getSuccessor(Node nodeToDelete){

        Node successorParent = nodeToDelete;
        Node successor = nodeToDelete;

        Node current = nodeToDelete.right; //right child

        while(current != null){ //start going left down the tree until node has no left child
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        //if successor is not a right child
        if(successor != nodeToDelete.right){
            successorParent.left = successor.right;
            successor.right = nodeToDelete.right;
        }
        return successor;
    }

    public int depth(Node root){
        if(root == null){
            return 0;
        }
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    public int depthSum(Node root){
        int count = 0;
        Node current = root;
        Node goLeft = root.left;
        Node goRight = root.right;
        int depth = 2;

        // for root
        count += 1 * root.val;

        while(goLeft != null && goRight != null){
            count += depth * (goLeft.val + goRight.val);
            depth++;
            goLeft = goLeft.left;
            goRight = goRight.right;
        }

        return count;
    }

    public int depthSum2(Node root, int depth){
        if(root == null){
            return 0;
        }
        return depth * root.val + (depthSum2(root.left, depth+1) + depthSum2(root.right, depth+1));
    }

    public int countLeft(BST tree, Node node) {

        if(node == null){
            return 0;
        }

        int goRight = countLeft(tree, node.right);
        int leftCounter = countLeft(tree, node.left);

        if(node.left != null){
            leftCounter += 1;
        }


        return goRight + leftCounter;
    }

    public int countEmpty(BST tree, Node node) {
        if(node == null){
            return 1;
        }
        else {

//            int goRight = countEmpty(tree, node.left);
//            int goLeft = countEmpty(tree, node.right);
            return countEmpty(tree, node.left) + countEmpty(tree, node.right);
        }


    }

}
