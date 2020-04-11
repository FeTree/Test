/*
Author: David Eisenbaum
Comp 182
Professor Barnes
Project 3
 */
package Comp182.Project3;

import java.util.*;
public class BSTP3 {

    private int power;
    private ArrayList<Integer> keys;
    private BSTree tree;

    private Sample createTrial, deleteTrial, reinsertTrial;

    final int simulationRun = 1000;
    public BSTP3(int power) {
        this.power = power;
        tree = new BSTree();
        keys = new ArrayList<>();
        createKey(); //adds keys to arrayList
        createTrial = new Sample();
        deleteTrial = new Sample();
        reinsertTrial = new Sample();

        for(int i = 0; i< simulationRun ; i++){
            insertNodes(); //adds nodes and creates the tree
            nodeLevel(createTrial); //gets level value
            tree.removeHalfNodes(tree.getRoot());//removes half of the nodes
            nodeLevel(deleteTrial);
            insertNodes();
            nodeLevel(reinsertTrial);
        }

        createTrial.computeStats(createTrial.getData());
        System.out.println("Create max: "+createTrial.getMax());
        System.out.println("Create average: "+createTrial.getMean());

        deleteTrial.computeStats(deleteTrial.getData());
        System.out.println("Delete max:" + createTrial.getMax());
        System.out.println("Delete average:" + createTrial.getMean());

        reinsertTrial.computeStats(reinsertTrial.getData());
        System.out.println("reinsert max:" + reinsertTrial.getMax());
        System.out.println("reinsert average:" + reinsertTrial.getMean());

    }

    public void nodeLevel(Sample s){
        int level = tree.height(tree.getRoot());
        s.add(level);
    }

    public void createKey(){
        int n = (int) Math.pow(2, power)-1;
        for (int i = 0; i < n; i++) keys.add(i); // initialize key
        Collections.shuffle(keys); // randomize key
    }

    public void insertNodes(){
        for(Integer i: keys){
         BSTElement e = new BSTElement(i);
         BSTNode node = new BSTNode(e);
         if(tree.getRoot() == null) tree.setRoot(node);
         else tree.insert(tree.getRoot(), node);
        }
    }

    public static void main(String args[]){
        BSTP3 project = new BSTP3(10);
    }

}
