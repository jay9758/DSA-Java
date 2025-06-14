//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

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
public class Serialize_and_deserialize_Binary_Tree {
    
    public static String serialize(Node root){
        if (root==null) {
            return "";
        }
        Queue<Node> q=new LinkedList<>();
        StringBuilder res=new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) {
            Node node=q.poll();
            if (node==null) {
                res.append("#"+",");
                continue;
            }
            res.append(node.data+",");
            q.add(node.left);
            q.add(node.right);
        }
        return res.toString();
    }

    public static Node deserialize(String s){
        if (s=="") {
            return null;
        }
        Queue<Node> q=new LinkedList<>();
        String[] values=s.split(",");
        Node root=new Node(Integer.parseInt(values[0]));
        q.add(root);
        for (int i = 1; i < values.length; i++) {
            Node node=q.poll();
            if (!values[i].equals("#")) {
                Node left=new Node(Integer.parseInt(values[i]));
                node.left=left;
                q.add(left);
            }
            if (!values[++i].equals("#")) {
                Node right=new Node(Integer.parseInt(values[i]));
                node.right=right;
                q.add(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root=new Node(10);
        root.left=new Node(20);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right=new Node(30);
        root.right.left=new Node(60);

        String ans=serialize(root);
        System.out.println(ans);

        Node newRoot=deserialize(ans);
        System.out.println(newRoot.data);
        System.out.print(newRoot.left.data+" ");
        System.out.println(newRoot.right.data);
        System.out.print(newRoot.left.left.data+" ");
        System.out.print(newRoot.left.right.data+" ");
        System.out.print(newRoot.right.left.data+" ");
    }
}
