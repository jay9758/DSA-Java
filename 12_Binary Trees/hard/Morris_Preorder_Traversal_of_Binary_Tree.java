
import java.util.ArrayList;
import java.util.List;

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
public class Morris_Preorder_Traversal_of_Binary_Tree {
    
    public static List<Integer> morrisPreorderTraversal(Node root){
        List<Integer> preorder=new ArrayList<>();
        Node curr=root;
        while (curr!=null) {
            if (curr.left==null) {
                preorder.add(curr.data);
                curr=curr.right;
            }
            else{
                Node prev=curr.left;
                while (prev.right!=null && prev.right!=curr) {
                    prev=prev.right;
                }
                if (prev.right==null) {
                    prev.right=curr;
                    preorder.add(curr.data);
                    curr=curr.left;
                }
                else {
                    prev.right=null;
                    curr=curr.right;
                }
            }
        }
        return preorder;
    }


    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        List<Integer> ans=morrisPreorderTraversal(root);
        System.out.println(ans);
    }
}
