//https://www.naukri.com/code360/problems/predecessor-and-successor-in-bst_893049
//https://www.geeksforgeeks.org/problems/predecessor-and-successor/1

//https://www.geeksforgeeks.org/problems/inorder-successor-in-bst/1

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
public class Inorder_Successor_in_BST{

    public static Node inorderSuccessor(Node root,int v){
        Node successor=null;
        while (root!=null) {
            if (root.data<=v) {
                root=root.right;
            }
            else{
                successor=root;
                root=root.left;
            }
        }
        return successor;
    }

    public static Node inorderPredecessor(Node root,int v){
        Node predecessor=null;
        while (root!=null) {
            if (root.data<v) {
                predecessor=root;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return predecessor;
    }


    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(10);
        root.right.right=new Node(14);

        int v=12;

        Node successor= inorderSuccessor(root,v);
        Node predecessor= inorderPredecessor(root, v);
        System.out.println("successor "+successor.data);
        System.out.println("predecessor "+predecessor.data);
    }
}
