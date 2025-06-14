//https://www.geeksforgeeks.org/problems/preorder-traversal-iterative/1

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
public class Iterative_Preorder_Traversal {

    public static List<Integer> iterativePreorderTraversal(Node root){
        List<Integer> ans=new ArrayList<Integer>();
        Stack<Node> st=new Stack<Node>();
        if (root==null) {
            return ans;
        }

        st.push(root);
        while (!st.isEmpty()) {
            root=st.pop();
            ans.add(root.data);
            if (root.right!=null) {
                st.push(root.right);
            }
            if (root.left!=null) {
                st.push(root.left);
            }
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

        List<Integer> ans=iterativePreorderTraversal(root);
        System.out.println(ans);
    }
}
