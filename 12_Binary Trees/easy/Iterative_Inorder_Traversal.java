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
public class Iterative_Inorder_Traversal {

    public static List<Integer> iterativeInorderTraversal(Node root){
        List<Integer> ans=new ArrayList<Integer>();
        Stack<Node> st=new Stack<Node>();
    
        Node node=root;
        while (true) {
            if (node!=null) {
                st.push(node);
                node=node.left;
            }
            else{
                if (st.isEmpty()) {
                    break;
                }
                node=st.pop();
                ans.add(node.data);
                node=node.right;
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

        List<Integer> ans=iterativeInorderTraversal(root);
        System.out.println(ans);
    }
}
