//https://www.geeksforgeeks.org/problems/postorder-traversal-iterative/1

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
public class Iterative_Postorder_Traversal {

    public static List<Integer> iterativePostorderTraversal(Node root){
        List<Integer> ans=new ArrayList<Integer>();
        Stack<Node> st=new Stack<Node>();
        
        Node curr=root;
        Node temp;

        while (curr!=null || !st.isEmpty()) {
            if (curr!=null) {
                st.push(curr);
                curr=curr.left;
            }
            else{
                temp=st.peek().right;
                if (temp==null) {
                    temp=st.peek();
                    st.pop();
                    ans.add(temp.data);
                    while (!st.isEmpty() && temp==st.peek().right) {
                        temp=st.peek();
                        st.pop();
                        ans.add(temp.data);
                    }
                }
                else{
                    curr=temp;
                }
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

        List<Integer> ans=iterativePostorderTraversal(root);
        System.out.println(ans);
    }
}
