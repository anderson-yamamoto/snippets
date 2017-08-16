package com.atto.challenges.binarytree;

public class Node {
    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node right;
    Node left;
    int data;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void traverseInOrder(Node n) {
        if (n.left != null)
            traverseInOrder(n.left);
        System.out.println(n.data);
        if (n.right != null)
            traverseInOrder(n.right);
        
    }

    public void addInOrder(int newData) {
        if (this.data < newData) {
            if (this.right == null)
                this.right = new Node(newData);
            else
                this.right.addInOrder(newData);
        } else if (this.data > newData) {
            if (this.left == null)
                this.left = new Node(newData);
            else
                this.left.addInOrder(newData);
        } else {
            System.out.println("equal to this node");
        }
    }
    
    public void deleteInOrder(int deletingData) {
        if (this.data < deletingData) {
            if (this.right == null)
                this.right = new Node(deletingData);
            else
                this.right.addInOrder(deletingData);
        } else if (this.data > deletingData) {
            if (this.left == null)
                this.left = new Node(deletingData);
            else
                this.left.addInOrder(deletingData);
        } else {
            System.out.println("equal to this node");
        }
    }
    
    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
