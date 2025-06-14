//https://leetcode.com/problems/binary-tree-postorder-traversal/

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
public class Postorder_Traversal {

    public static void postorderTraversal(Node root,List<Integer> ans){
        if (root==null) {
            return;
        }
        postorderTraversal(root.left,ans);
        postorderTraversal(root.right,ans);
        ans.add(root.data);
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
        postorderTraversal(root,ans);
        System.out.println(ans);
    }
}
