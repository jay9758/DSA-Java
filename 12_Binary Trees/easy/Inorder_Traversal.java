//https://leetcode.com/problems/binary-tree-inorder-traversal/description/

import java.util.ArrayList;
import java.util.List;

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
public class Inorder_Traversal {

    public static void inorderTraversal(Node root,List<Integer> ans){
        if (root==null) {
            return;
        }
        inorderTraversal(root.left,ans);
        ans.add(root.data);
        inorderTraversal(root.right,ans);
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        List<Integer> ans=new ArrayList<>();
        inorderTraversal(root,ans);
        System.out.println(ans);
    }
}
