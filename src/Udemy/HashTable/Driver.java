package Udemy.HashTable;

public class Driver {
    public static void main(String[] args) {
        HashTable table = new HashTable(19);

        table.insert("Apple");
        table.insert("Hello");
        table.insert("Feeling");
        table.insert("Africa");
        table.insert("Speed");
        table.insert("Milk");
        table.insert("Raffi");

        System.out.println(table.find("Hello"));
    }


}
