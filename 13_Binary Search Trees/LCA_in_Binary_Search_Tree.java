//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

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
public class LCA_in_Binary_Search_Tree{

    public static Node lowestCommonAncestor(Node root,Node p,Node q){
        if (root==null) {
            return null;
        }
        int curr=root.data;
        if (curr<p.data && curr<q.data) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (curr>p.data && curr>q.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }


    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(10);
        root.right.right=new Node(14);

        Node LCA= lowestCommonAncestor(root,root.left.left,root.left.right);
        System.out.println(LCA.data);
    }
}
