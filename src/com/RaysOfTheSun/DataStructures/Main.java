package com.RaysOfTheSun.DataStructures;
import static java.lang.System.out;
import com.RaysOfTheSun.DataStructures.Tree.BinarySearchTree.BinarySearchTree;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int data[] = new int[]{10, 50, 40, 50, 60, 30, 45, 55, 70, 51, 56, 61, 80, 5, 4, 6};

        for (int i = 0; i < data.length; i++){
            tree.Add(data[i]);
        }

        tree.ShowTraversals();
        tree.Remove(50);

    }
}
