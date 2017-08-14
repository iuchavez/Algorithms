package com.cecs328;

/**
 * Created by Isaac on 7/29/2017.
 */
public class Node{
    private int key;
    private Node left;
    private Node right;

    public Node(int i){
        key = i;
        left = null;
        right = null;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void insert(int i){
        if (i < key){
            if (left == null){
                left = new Node(i);
            } else {
                left.insert(i);
            }
        } else {
            if (right == null){
                right = new Node(i);
            } else {
                left.insert(i);
            }
        }
    }

    public int getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setLeft(Node n){
            left = n;
    }

    public void setRight(Node n){
            right = n;
    }

}