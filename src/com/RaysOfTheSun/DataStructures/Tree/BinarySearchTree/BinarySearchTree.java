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

    private Node GetExistingChild(Node node){
        if(node.leftChild != null){
            return node.leftChild;
        }
        else {
            return node.rightChild;
        }
    }

    private int GetMinimumValue(Node node){
        if(node.leftChild != null){
            return GetMinimumValue(node.leftChild);
        }
        else{
            return node.data;
        }
    }



    private boolean Find(Node node, int data){
        if (node == null){
            return false;
        }
        else if(data < node.data) {
            return Find(node.leftChild, data);
        }
        else if(data > node.data) {
            return Find(node.rightChild, data);
        }
        else{
            return true;
        }
    }

    public boolean Find(int data){
        return Find(rootNode, data);
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
                node = GetExistingChild(node);
            }
            else{
                // the node has two children
                node.data = GetMinimumValue(node.rightChild); /* Going down the right subtree's
                left subtree will get us the minimum value in the current node's right subtree*/
                node.rightChild = Remove(node.rightChild, node.data);
            }
        }

        return node;
    }

    public void Remove(int data){
        if (Find(data)) {
            rootNode = Remove(rootNode, data);
            if(Find(data)) Remove(data); /* if we find the same item after the initial deletion,
            go do it again */
        }
        else{
            System.out.println(String.format("Error: The item %d is not in the tree", data));
        }
    }

    private void TraverseInorder(Node node){
        if(node == null) return;
        TraverseInorder(node.leftChild);
        System.out.print(String.format("%d, ", node.data));
        TraverseInorder(node.rightChild);
    }

    private void TraversePreorder(Node node){
        if(node == null) return;
        System.out.print(String.format("%d, ", node.data));
        TraverseInorder(node.leftChild);
        TraverseInorder(node.rightChild);
    }

    private void TraversePostOrder(Node node){
        if(node == null) return;
        TraverseInorder(node.leftChild);
        TraverseInorder(node.rightChild);
        System.out.print(String.format("%d, ", node.data));
    }

    public void TraverseInorder(){
        TraverseInorder(rootNode);
    }

    public void TraversePreorder(){
        TraversePreorder(rootNode);
    }

    public void TraversePostOrder(){
        TraversePostOrder(rootNode);
    }
}
