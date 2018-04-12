package com.RaysOfTheSun.DataStructures.Tree.BinarySearchTree;

public class BinarySearchTree {
    Node rootNode = null;

    private Node Add(Node node, int data){
        if (node == null){
            node = new Node(data);
        }
        else if(data <= node.data){
            node.leftChild = Add(node.leftChild, data);
        }
        else{
            node.rightChild = Add(node.rightChild, data);
        }

        return node;
    }

    public void Add(int data){
        rootNode = Add(rootNode, data);
    }

    private Node GetExistsingChild(Node node){
        if(node.leftChild != null){
            return node.leftChild;
        }
        else {
            return node.rightChild;
        }
    }

    private int GetMinimumValue(Node node){
        if(node != null){
            return GetMinimumValue(node.leftChild);
        }
        else{
            return node.data;
        }
    }

    private Node Remove(Node node, int data){
        if(data < node.data){
            node.leftChild = Remove(node.leftChild, data);
        }
        else if(data > node.data){
            node.rightChild = Remove(node.rightChild, data);
        }
        else{
            if((node.leftChild == null) && (node.rightChild == null)){
                node = null;
            }
            else if(((node.rightChild != null) && (node.leftChild == null)) ||
            ((node.leftChild != null) && (node.rightChild == null))){
                node = GetExistsingChild(node);
            }
            else{
                // the node has two children
                node.data = GetMinimumValue(node.rightChild); /* Going down the right subtree's
                left subtree will get us the minimum value in the current node's right subtree*/
                node.rightChild = Remove(node.rightChild, node.data);
            }
        }
    }
}
