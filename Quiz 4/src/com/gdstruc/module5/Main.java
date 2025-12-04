package com.gdstruc.module5;

public class Main {
    public static void main(String[] args) {

        Player ploo = new Player(134, "Plooful", 135);
        Player wardell = new Player(634, "Wardell", 640);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player subroza = new Player(536, "Subroza", 640);
        Player annieDro = new Player(6919, "AnnieDro", 593);

        SimpleHashtable hashtable = new SimpleHashtable();

        // get the names
        hashtable.put(ploo.getName(), ploo);
        hashtable.put(wardell.getName(), wardell);
        hashtable.put(deadlyJimmy.getName(), deadlyJimmy);
        hashtable.put(subroza.getName(), subroza);
        hashtable.put(annieDro.getName(), annieDro);

        // get operations
        System.out.println("Found: " + hashtable.get("DeadlyJimmy"));
        System.out.println("Found: " + hashtable.get("Subroza"));

        // shows remove function
        System.out.println("\n=== Testing Remove Function ===");
        Player removed = hashtable.remove("DeadlyJimmy");
        System.out.println("Removed player object: " + removed);

        // verifies the removal
        System.out.println("Getting 'DeadlyJimmy' after removal: " + hashtable.get("DeadlyJimmy"));
    }
}