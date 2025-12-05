package com.gdstruc.module6;

public class Node {
    private int data;
    private Node rightChild;
    private Node leftChild;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value == data) {
            return; // duplicate value
        }

        if (value < data) {
            if (leftChild == null)
            {
                leftChild = new Node(value);
            }
            else
            {
                leftChild.insert(value);
            }
        }
        else
        {
            if (rightChild == null)
            {
                rightChild = new Node(value);
            }
            else
            {
                rightChild.insert(value);
            }
        }
    }

    public void traverseInOrder()
    {
        if (leftChild != null)
        {
            leftChild.traverseInOrder();
        }
        System.out.print(data + " ");

        if (rightChild != null)
        {
            rightChild.traverseInOrder();
        }
    }

    // NEW: Traverse in descending order (right, root, left)
    public void traverseInOrderDescending()
    {
        if (rightChild != null)
        {
            rightChild.traverseInOrderDescending();
        }
        System.out.print(data + " ");

        if (leftChild != null)
        {
            leftChild.traverseInOrderDescending();
        }
    }

    // get min node
    public Node getMin()
    {
        if (leftChild == null)
        {
            return this; // min node
        }
        return leftChild.getMin(); // keep going left
    }

    // get max node
    public Node getMax()
    {
        if (rightChild == null)
        {
            return this; // max node
        }
        return rightChild.getMax(); // keep going right
    }

    public Node get(int value)
    {
        if (value == data)
        {
            return this;
        }

        if (value < data)
        {
            if (leftChild != null)
            {
                return leftChild.get(value);
            }
        }
        else
        {
            if (rightChild != null)
            {
                return rightChild.get(value);
            }
        }

        return null;
    }


    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public Node getLeftChild()
    {
        return leftChild;
    }

    public void setLeftChild(Node leftChild)
    {
        this.leftChild = leftChild;
    }

    public Node getRightChild()
    {
        return rightChild;
    }

    public void setRightChild(Node rightChild)
    {
        this.rightChild = rightChild;
    }

    @Override
    public String toString()
    {
        return "Node{data=" + data + "}";
    }
}