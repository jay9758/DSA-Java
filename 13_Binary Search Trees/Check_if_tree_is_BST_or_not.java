//https://leetcode.com/problems/validate-binary-search-tree/submissions/1585219340/

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
public class Check_if_tree_is_BST_or_not{

    public static boolean isBST(Node root){
        return checkTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    public static boolean checkTree(Node root,Long minVal,Long maxVal ){
        if (root==null) {
            return true;
        }
        if (root.data>=maxVal || root.data<=minVal) {
            return false;
        }
        return checkTree(root.left, minVal, (long)root.data) &&
               checkTree(root.right, (long)root.data, maxVal);
    }


    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(10);
        root.right.right=new Node(14);

        System.out.println(isBST(root));
    }
}
