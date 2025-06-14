//https://leetcode.com/problems/binary-tree-right-side-view/

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

public class Right_View_of_Binary_Tree {

    public static void Traversal(Node root,int level,List<Integer> ans){
        if (root==null) {
            return;
        }
        if (level==ans.size()) {
            ans.add(root.data);
        }
        Traversal(root.right, level+1, ans);
        Traversal(root.left, level+1, ans);
    }
    
    public static List<Integer> rightView(Node root){
        List<Integer> ans=new ArrayList<>();
        Traversal(root, 0, ans);
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

        List<Integer> ans=rightView(root);
        System.out.println(ans);
    }
}
