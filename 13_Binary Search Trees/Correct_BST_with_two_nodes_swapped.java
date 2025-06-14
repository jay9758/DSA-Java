//https://leetcode.com/problems/recover-binary-search-tree/

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
public class Correct_BST_with_two_nodes_swapped {

    private Node prev;
    private Node first;
    private Node middle;
    private Node last;

    private void inorder(Node root){
        if (root==null) {
            return;
        }
        inorder(root.left);
        if (prev!=null && root.data<prev.data) {
            if (first==null) {
                first=prev;
                middle=root;
            }
            else{
                last=root;
            }
        }
        prev=root;
        inorder(root.right);
    }

    public void correctTree(Node root){
        first=middle=last=null;
        prev=new Node(Integer.MIN_VALUE);
        inorder(root);
        if (first!=null && last!=null) {
            int t=first.data;
            first.data=last.data;
            last.data=t;
        }
        else{
            int t=first.data;
            first.data=middle.data;
            middle.data=t;
        }
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
        root.right.left=new Node(14);
        root.right.right=new Node(10);

        Correct_BST_with_two_nodes_swapped tree=new Correct_BST_with_two_nodes_swapped();

        System.out.println("Before swap-");
        printTree(root);
        tree.correctTree(root);
        System.out.println("After swap-");
        printTree(root);
    }
}
