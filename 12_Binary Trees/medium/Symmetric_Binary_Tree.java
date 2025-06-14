//https://leetcode.com/problems/symmetric-tree/

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

public class Symmetric_Binary_Tree {

    public static boolean checkSymmetric(Node left,Node right){
        if (left==null || right==null) {
            return left==right;
        }
        if (left.data!=right.data) {
            return false;
        }
        
        return checkSymmetric(left.left, right.right) && 
               checkSymmetric(left.right, right.left);
    }
    
    public static boolean isSymmetric(Node root){
        return root==null || checkSymmetric(root.left,root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(2);
        root.right.left=new Node(5);
        root.right.right=new Node(4);

        boolean ans=isSymmetric(root);
        System.out.println(ans);
    }
}
