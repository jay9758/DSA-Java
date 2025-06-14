//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
public class Construct_Binary_Tree_from_inorder_and_preorder {
    
    public static Node constructTree(int[] preorder,int[] inorder){
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        Node root=buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }

    public static Node buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map){
        if (preStart>preEnd || inStart>inEnd) {
            return null;
        }

        Node root=new Node(preorder[preStart]);
        int inRoot=map.get(root.data);
        int numLeft=inRoot - inStart;

        root.left=buildTree(preorder, preStart+1, preStart+numLeft, inorder, inStart, inRoot-1, map);
        root.right=buildTree(preorder, preStart+numLeft+1, preEnd, inorder, inRoot+1, inEnd, map);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder={10,20,40,50,30,60};
        int[] inorder={40,20,50,10,60,30};

        Node root=constructTree(preorder,inorder);
        System.out.println(root.data);
        System.out.print(root.left.data+" ");
        System.out.println(root.right.data);
        System.out.print(root.left.left.data+" ");
        System.out.print(root.left.right.data+" ");
        System.out.print(root.right.left.data+" ");
    }
}
