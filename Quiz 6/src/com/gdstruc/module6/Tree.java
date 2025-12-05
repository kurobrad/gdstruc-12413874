package com.gdstruc.module6;

public class Tree
{
    private Node root;

    public void insert(int value)
    {
        if (root == null)
        {
            root = new Node(value);
        }
        else
        {
            root.insert(value);
        }
    }

    public void traverseInOrder()
    {
        if (root != null)
        {
            root.traverseInOrder();
        }
    }

    // node with the min value
    public Node getMin()
    {
        if (root == null)
        {
            return null;
        }
        return root.getMin();
    }

    // node with max value
    public Node getMax()
    {
        if (root == null)
        {
            return null;
        }
        return root.getMax();
    }

    // desc order
    public void traverseInOrderDescending()
    {
        if (root != null)
        {
            root.traverseInOrderDescending();
        }
    }

}