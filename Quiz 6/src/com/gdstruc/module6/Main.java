package com.gdstruc.module6;

public class Main {
    public static void main(String[] args)
    {
        Tree tree = new Tree();

        tree.insert(10);
        tree.insert(11);
        tree.insert(1);
        tree.insert(20);
        tree.insert(25);
        tree.insert(40);
        tree.insert(16);

        System.out.println("=== Testing Tree Functions ===");
        System.out.println("Min: " + tree.getMin()); // min
        System.out.println("Max: " + tree.getMax()); // max

        System.out.println("\n=== Traversals ===");
        // traverse ascend
        System.out.print("in-order (ascending): ");
        tree.traverseInOrder();
        System.out.println();

        // traverse descend
        System.out.print("in-order (descending): ");
        tree.traverseInOrderDescending();
        System.out.println();
    }
}