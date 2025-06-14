//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

import java.util.HashMap;
import java.util.Map;

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
public class Construct_Binary_Tree_from_Postorder_and_Inorder {
    
    public static Node constructTree(int[] postorder,int[] inorder){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Node root=buildTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    public static Node buildTree(int[] postorder,int postStart,int postEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
        if (postStart>postEnd || inStart>inEnd) {
            return null;
        }

        Node root=new Node(postorder[postEnd]);
        int inRoot=map.get(root.data);
        int numLeft=inRoot - inStart;

        root.left=buildTree(postorder, postStart, postStart+numLeft-1, inorder, inStart, inRoot-1, map);
        root.right=buildTree(postorder, postStart+numLeft, postEnd-1, inorder, inRoot+1, inEnd, map);
        return root;
    }


    public static void main(String[] args) {
        int[] postorder={40,50,20,60,30,10};
        int[] inorder={40,20,50,10,60,30};

        Node root=constructTree(postorder,inorder);
        System.out.println(root.data);
        System.out.print(root.left.data+" ");
        System.out.println(root.right.data);
        System.out.print(root.left.left.data+" ");
        System.out.print(root.left.right.data+" ");
        System.out.print(root.right.left.data+" ");
    }
}
