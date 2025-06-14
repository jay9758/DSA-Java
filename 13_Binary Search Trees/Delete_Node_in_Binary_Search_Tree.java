//https://leetcode.com/problems/delete-node-in-a-bst/

import java.util.LinkedList;
import java.util.Queue;


class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class Delete_Node_in_Binary_Search_Tree {

    public static Node findLastRight(Node root){
        if (root.right==null) {
            return root;
        }
        return findLastRight(root.right);
    }

    public static Node helper(Node root){
        if (root.left==null) {
            return root.right;
        }
        if (root.right==null) {
            return root.left;
        }
        Node rightChild=root.right;
        Node lastRight=findLastRight(root.left);
        lastRight.right=rightChild;
        return root.left;
    }

    public static Node deleteNode(Node root,int v){
        if (root==null) {
            return root;
        }
        if (root.data==v) {
            return helper(root);
        }
        Node dummy=root;

        while (root!=null) {
            if (root.data>v) {
                if (root.left!=null && root.left.data==v) {
                    root.left= helper(root.left);
                    break;
                }
                else{
                    root=root.left;
                }
            }
            else{
                if (root.right!=null && root.right.data==v) {
                    root.right=helper(root.right);
                    break;
                }
                else{
                    root=root.right;
                }
            }
        }
        return dummy;
    }

    public static void printTree(Node root){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size=q.size();
            for (int i = 0; i < size; i++) {
                Node node=q.poll();
                System.out.print(node.data+" ");
                if (node.left!=null) q.add(node.left);
                if (node.right!=null) q.add(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(10);
        root.right.right=new Node(14);
        
        int v=12;

        Node Root=deleteNode(root,v);

        printTree(Root);
    }
}
