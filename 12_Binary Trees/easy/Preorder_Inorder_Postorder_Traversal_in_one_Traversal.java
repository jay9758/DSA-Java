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
class Pair{
    Node node;
    int no;
    Pair(Node node,int no){
        this.node=node;
        this.no=no;
    }
}
public class Preorder_Inorder_Postorder_Traversal_in_one_Traversal {

    public static List<List<Integer>> prePostInorderTraversal(Node root){
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> pre=new ArrayList<Integer>();
        List<Integer> in=new ArrayList<Integer>();
        List<Integer> post=new ArrayList<Integer>();
        Stack<Pair> st=new Stack<Pair>();

        st.push(new Pair(root, 1));

        while (!st.isEmpty()) {
            Pair it=st.pop();
            if (it.no==1) {
                pre.add(it.node.data);
                it.no++;
                st.push(it);
                if (it.node.left!=null) {
                    st.push(new Pair(it.node.left, 1));
                }
            }
            else if (it.no==2) {
                in.add(it.node.data);
                it.no++;
                st.push(it);
                if (it.node.right!=null) {
                    st.push(new Pair(it.node.right, 1));
                }
            }
            else{
                post.add(it.node.data);
            }
        }
        ans.add(pre);
        ans.add(in);
        ans.add(post);
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

        List<List<Integer>> ans=prePostInorderTraversal(root);
        System.out.println(ans);
    }
}
