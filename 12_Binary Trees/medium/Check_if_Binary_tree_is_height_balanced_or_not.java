//https://leetcode.com/problems/balanced-binary-tree/

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
public class Check_if_Binary_tree_is_height_balanced_or_not {

    public static boolean checkTree(Node root){
        return heightOfTree(root) != -1;
    }

    public static int heightOfTree(Node root){
        if (root==null) {
            return 0;
        }
        int lh=heightOfTree(root.left);
        if (lh==-1) {
            return -1;
        }
        int rh=heightOfTree(root.right);
        if (rh==-1) {
            return -1;
        }
        if (Math.abs(lh-rh)>1) {
            return -1;
        }
        return 1+Math.max(lh, rh);
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        boolean ans=checkTree(root);
        System.out.println(ans);
    }
}
