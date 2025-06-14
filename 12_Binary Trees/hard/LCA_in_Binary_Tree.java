//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
public class LCA_in_Binary_Tree {

    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if (root==null || root==p || root==q) {
            return root;
        }
        Node left=lowestCommonAncestor(root.left, p, q);
        Node right=lowestCommonAncestor(root.right, p, q);
        if (left==null) {
            return right;
        }
        else if (right==null) {
            return left;
        }
        else{
            return root;
        }
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        Node ans=lowestCommonAncestor(root, root.left.left, root.right.left);
        System.out.println(ans.data);
    }
}
