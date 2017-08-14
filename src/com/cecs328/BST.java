package com.cecs328;

/**
 * Created by Isaac on 7/25/2017.
 */
public class BST {
    Node root;

    /**
     * Constructor for a BST
     */
    public BST(){}

    /**
     * Checks if node already exists, if not then the value is inserted in the proper location.
     * This method uses a helper method.
     * @param i the value to be added to the BST
     */
    public void insert(int i){
        if(find(i)){
            //Do nothing
        } else {
            insert(root, i);
        }
    }

    /**
     * Recursively finds the proper place for newly inserted node
     * @param n
     * @param intToInsert
     * @return
     */
    private Node insert(Node n, int intToInsert){
        if(root == null){
            root = new Node(intToInsert);
            return root;
        }
        if(n == null){
            n = new Node(intToInsert);
        }else {
            if (intToInsert < n.getKey()) {
                n.setLeft(insert(n.getLeft(), intToInsert));
            } else {
                n.setRight(insert(n.getRight(), intToInsert));
            }
        }
        return n;
    }

    /**
     * Finds the size of the BST
     * @param n
     * @return
     */
    private int size(Node n){
        if(n != null){
            if(n.getRight() == null){
                if(n.getLeft() == null){
                    return 1;
                }
            }
            return (size(n.getLeft())+size(n.getRight()))+1;
        }
        return 0;
    }

    /**
     * This is a static method which prints the elements of the BST subtree in order
     * @param n
     */
    public static void subtree(Node n){
        if(n != null){
            subtree(n.getLeft());
            System.out.println(n.getKey());
            subtree(n.getRight());
        }
    }

    /**
     * This returns the min value of in the BST
     * @param n is the root node of the BST
     */
    public int find_min(Node n){
        if(n.getLeft() == null){
            return n.getKey();
        }else{
            return find_min(n.getLeft());
        }
    }

    /**
     * This returns the max value of in the BST
     * @param n is the root node of the BST
     */
    public int find_max(Node n){
        if(n.getRight() == null){
            return n.getKey();
        }else{
            return find_max(n.getRight());
        }
    }

    /**
     * This is a method for getting back a found node from a BSD searching ny an integer
     * @param i this is the integer that you are looking for.
     * @return
     */
    public Node getNode(int i){
        return getNode(root, i);
    }

    /**
     * Look for an integer value within the BST and returns the node when found
     * @param i this is the integer value
     */
    public Node getNode(Node n, int i){
        if(n != null) {
            if (i == n.getKey()) {
                return n;
            } else if (i < n.getKey()) {
                return getNode(n.getLeft(), i);
            } else if (i > n.getKey()) {
                return getNode(n.getRight(), i);
            }
        }
        return null;
    }

    /**
     * This is a helped method that kick-starts the finding process
     * @param i this is the integer that is required
     */
    public boolean find(int i){
        return find(root, i);
    }

    /**
     * Looks for a specific node and returns true if it is found
     * @param n
     * @param i
     * @return
     */
    public boolean find(Node n, int i){
        if(n != null) {
            if (i == n.getKey()) {
                return true;
            } else if (i < n.getKey()) {
                return find(n.getLeft(), i);
            } else if (i > n.getKey()) {
                return find(n.getRight(), i);
            }
        }
        return false;
    }

    /**
     * Looks for a specific node and returns true if it is found
     * @param n
     * @param i
     * @return
     */
    public void delete(Node n, int i){
        if(n != null) {
            if (i == n.getKey()) {
                if (n.getRight() == null){
                    if(n.getLeft() == null){
                        // First case, no children
                        n = null;
                    } else {
                        // Left child only
                        n = n.getLeft();
                    }
                } else {
                    // Has a right child
                    if(n.getLeft() == null){
                        // No left child
                        n = n.getRight();
                    } else {
                        // Both left and right child
                        Node temp = n.getRight();
                        while(temp.getLeft() != null){
                            temp = n.getLeft();
                        }
                        n = temp;
                    }
                }

            } else if (i < n.getKey()) {
                delete(n.getLeft(), i);
            } else if (i > n.getKey()) {
                delete(n.getRight(), i);
            }
        }
    }

    public static void main(String[] args){
        BST bst = new BST();
        bst.insert(6);
        bst.insert(9);
        bst.insert(2);
        bst.insert(11);
        bst.insert(44);
        bst.insert(8);
        bst.insert(55);
        bst.insert(43);
        bst.insert(22);
        bst.insert(17);
        bst.insert(41);
        bst.insert(3);
        subtree(bst.root);
        System.out.println("This is the min: "+bst.find_min(bst.root));
        System.out.println("This is the max: "+bst.find_max(bst.root));
        System.out.println("This is the size: "+bst.size(bst.root));
        System.out.println("Find 41: "+bst.find(41));
        System.out.println("Find 4000: "+bst.find(4000));
        System.out.println("Delete node 22");
        bst.delete(bst.root, 22);
        subtree(bst.root);
    }
}
