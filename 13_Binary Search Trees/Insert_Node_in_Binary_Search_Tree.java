//https://leetcode.com/problems/insert-into-a-binary-search-tree/

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
public class Insert_Node_in_Binary_Search_Tree {

    public static Node insertNode(Node root,int v){
        if (root==null) {
            return new Node(v);
        }
        Node curr=root;
        while (true) {
            if (v<curr.data) {
                if (curr.left!=null) curr=curr.left;
                else{
                    curr.left=new Node(v);
                    break;
                }
            }
            else{
                if (curr.right!=null) curr=curr.right;
                else{
                    curr.right=new Node(v);
                    break;
                }
            }
        }
        return root;
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
        
        int v=13;

        Node Root=insertNode(root,v);

        printTree(Root);
    }
}
