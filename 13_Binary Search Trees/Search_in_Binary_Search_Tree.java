//https://leetcode.com/problems/search-in-a-binary-search-tree/

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
public class Search_in_Binary_Search_Tree {

    public static Node search(Node root,int v){
        while (root!=null && root.data!=v) {
            root = root.data<v ? root.right : root.left;
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
        
        int v=10;

        Node ans=search(root,v);
        System.out.println(ans.data);
    }
}
