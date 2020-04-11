/*
Author: David Eisenbaum
Comp 182
Professor Barnes
Project 3
 */

package Comp182.Project3;

public class BSTElement implements Comparable<BSTElement>{

    private Integer key;


    public BSTElement(Integer value){
        this.key = value;
    }

    public Integer getKey() {
        return key;
    }

    public String toString(){
        return String.format("Key is: %d", key);
    }

    public int compareTo(BSTElement other){
        return key.compareTo(other.key);
    }
}
