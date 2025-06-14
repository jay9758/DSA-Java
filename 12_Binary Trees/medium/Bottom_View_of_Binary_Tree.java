//https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

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
    int line;

    Pair(Node node,int line) {
        this.node=node;
        this.line=line;
    }
}
public class Bottom_View_of_Binary_Tree {
    
    public static List<Integer> bottomView(Node root){
        List<Integer> ans=new ArrayList<>();
        if (root==null) {
            return ans;
        }
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<Pair>();
        q.offer(new Pair(root, 0));
        
        while (!q.isEmpty()) {
            Pair it=q.poll();
            Node temp=it.node;
            int x=it.line;
            map.put(x,temp.data);
            if (temp.left!=null) {
                q.offer(new Pair(temp.left, x-1));
            }
            if (temp.right!=null) {
                q.offer(new Pair(temp.right, x+1));
            }
        }
        ans.addAll(map.values());
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

        List<Integer> ans=bottomView(root);
        System.out.println(ans);
    }
}
