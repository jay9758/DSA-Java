//https://www.geeksforgeeks.org/problems/inorder-traversal-iterative/1

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
public class Postorder_Traversal_using_2_stack {

    public static List<Integer> postorderTraversal2stack(Node root){
        List<Integer> ans=new ArrayList<Integer>();
        Stack<Node> st1=new Stack<Node>();
        Stack<Node> st2=new Stack<Node>();
    
        st1.push(root);
        while (!st1.isEmpty()) {
            root=st1.pop();
            st2.push(root);
            if (root.left!=null) {
                st1.push(root.left);
            }
            if (root.right!=null) {
                st1.push(root.right);
            }
        }
        while (!st2.isEmpty()) {
            ans.add(st2.pop().data);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        List<Integer> ans=postorderTraversal2stack(root);
        System.out.println(ans);
    }
}
