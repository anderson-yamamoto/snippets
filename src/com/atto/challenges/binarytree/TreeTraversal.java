package com.atto.challenges.binarytree;

import java.util.Random;
import java.util.Stack;

public class TreeTraversal {

    public static void main(String[] args) {
        Node root = new Node(50);
        Random r = new Random();
        for (int i = 0; i < 2000; i++) {
            int rand = r.nextInt(100);
            System.out.println("Adding " + rand);
            root.addInOrder(rand);
        }

        root.traverseInOrder(root);
//        System.out.println(">>>>>");
//        EfficientNodeOperations.traverse(root, Order.POSTORDER);
//        System.out.println(">>>>>");
//        EfficientNodeOperations.traverse(root, Order.PREORDER);
        
        ListNodeOperations.traverseInOrder(root);
    }
}

class ListNodeOperations {
    public static void traverse(Node n, Order order) {
        Stack<Node> before = new Stack<Node>();
        Stack<Node> after = new Stack<Node>();
        before.push(n);
        while (!before.isEmpty()) {
            Node current = before.pop();
            if (Order.POSTORDER == order)
                pushToStack(before, current.left, current.right);
            else
                pushToStack(before, current.right, current.left);
            after.push(current);
        }

        System.out.println(after);
    }

    public static void traverseInOrder(Node n) {
        Node current = n;
        Stack<Node> stack = new Stack<Node>();

        main: while (current != null) {
            while (current.left != null) {
                stack.push(current);
                current = current.left;
            }
            System.out.println(current);
            if (current.right != null) {
                current = current.right;
            } else
            {
                do{
                    if (stack.size() == 0)
                        break main;
                    current = stack.pop();
                    System.out.println(current);
                } while (current.right == null);
                current = current.right;
            }
        } 
        
    }

    private static void pushToStack(Stack<Node> t, Node n1, Node n2) {
        if (n1 != null)
            t.push(n1);
        if (n2 != null)
            t.push(n2);
    }
}

enum Order {
    PREORDER, POSTORDER;
}