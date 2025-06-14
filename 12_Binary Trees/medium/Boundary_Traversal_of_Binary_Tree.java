//https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
//https://www.naukri.com/code360/problems/boundary-traversal_790725

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
public class Boundary_Traversal_of_Binary_Tree {

    public static boolean isLeaf(Node root){
        if (root.left==null && root.right==null) {
            return true;
        }
        return false;
    }

    public static void addLeftBoundary(Node root,List<Integer> ans){
        Node curr=root.left;
        while (curr!=null) {
            if (isLeaf(curr)==false) {
                ans.add(curr.data);
            }
            if(curr.left!=null){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
    }
    public static void addRightBoundary(Node root,List<Integer> ans){
        Node curr=root.right;
        List<Integer> temp=new ArrayList<>();
        while (curr!=null) {
            if (isLeaf(curr)==false) {
                temp.add(curr.data);
            }
            if(curr.right!=null){
                curr=curr.right;
            }
            else{
                curr=curr.left;
            }
        }
        for (int i = temp.size()-1; i >= 0; i--) {
            ans.add(temp.get(i));
        }
    }
    public static void addLeaves(Node root,List<Integer> ans){
        if (isLeaf(root)) {
            ans.add(root.data);
            return;
        }
        if (root.left!=null) {
            addLeaves(root.left, ans);
        }
        if (root.right!=null) {
            addLeaves(root.right, ans);
        }
    }
    
    public static List<Integer> boundaryTraversal(Node root){
        List<Integer> ans=new ArrayList<>();
        if (isLeaf(root)==false) {
            ans.add(root.data);
        }
        addLeftBoundary(root,ans);
        addLeaves(root,ans);
        addRightBoundary(root,ans);
        return ans;
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        List<Integer> ans=boundaryTraversal(root);
        System.out.println(ans);
    }
}
