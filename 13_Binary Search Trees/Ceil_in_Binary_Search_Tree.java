//https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1

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
public class Ceil_in_Binary_Search_Tree {

    public static int ceilOfValue(Node root,int v){
        int ceil=-1;
        while (root!=null) {
            if (root.data==v) {
                ceil=root.data;
                return ceil;
            }
            if (root.data>v) {
                ceil=root.data;
                root=root.left;
            }
            else{
                root=root.right;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(10);
        root.right.right=new Node(14);
        
        int v=6;

        int ceil=ceilOfValue(root,v);
        System.out.println(ceil);
    }
}
