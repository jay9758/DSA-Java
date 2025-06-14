//optimal
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/1583123843/

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
public class Flatten_Binary_Tree_to_LinkedList_method3optimal {

    public static void flattenTreeToLinkedList(Node root){
        Node curr=root;
        while (curr!=null) {
            if(curr.left!=null){
                Node prev=curr.left;
                while (prev.right!=null) {
                    prev=prev.right;
                }
                prev.right=curr.right;
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
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

        flattenTreeToLinkedList(root);
        while (root!=null) {
            System.out.print(root.data+" ");
            root=root.right;
        }
    }
}
