package Udemy.binarySearchTree;

public class App {

    public static void main(String args[]) {
        BST tree = new BST();
        tree.insert(18);
        tree.insert(20);
        tree.insert(5);
        tree.insert(1);


        System.out.println("CountEmpty: " + tree.countEmpty(tree, tree.root));
    }
}
