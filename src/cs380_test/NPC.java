package cs380_test;

abstract class NPC {
    String stats;

    NPC(String stats){
        this.stats = stats;
        //this.stats = "npc class-stats";
        System.out.println("npc construct called");
    }
}

class ItemFactory{
    static int getItem(int x){
        return x;
    }
}

class Allie extends NPC{
    String title;
    String name;


    public Allie(String stats, String title, String name) {
        super(stats);
        this.title = title;
        this.name = name;
    }
}

class Monster extends Allie{


    public Monster(String stats, String title, String name) {
        super(stats, title, name);
    }

    int getItem(){
        return ItemFactory.getItem((int)Math.random()*254);
    }
}

class Driver{
    public static void main(String[] args) {
        Monster m = new Monster("super123", "imgat", "1234");
        Allie a = new Allie("1", "2", "3");
        System.out.println(m.title);
    }
}
