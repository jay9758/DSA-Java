//https://www.naukri.com/code360/problems/path-in-a-tree_3843990

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
public class Root_to_Node_Path_in_Binary_Tree {

    public static boolean path(Node root,Node node,List<Integer> ans){
        if (root==null) {
            return false;
        }
        ans.add(root.data);
        if (root.data==node.data) {
            return true;
        }
        if (path(root.left, node, ans) || path(root.right, node, ans)) {
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
    }
    
    public static List<Integer> rootToNodePath(Node root,Node node){
        List<Integer> ans=new ArrayList<>();
        path(root,node,ans);
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

        List<Integer> ans=rootToNodePath(root,root.right.right);
        System.out.println(ans);
    }
}
