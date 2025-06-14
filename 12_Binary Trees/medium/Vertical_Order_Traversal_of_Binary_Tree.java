//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
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
class Tuple{
    Node node;
    int vertical;
    int level;
    Tuple(Node node,int vertical,int level){
        this.node=node;
        this.vertical=vertical;
        this.level=level;
    }
}
public class Vertical_Order_Traversal_of_Binary_Tree {

    public static List<List<Integer>> verticalTraversal(Node root){
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Tuple> q=new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple=q.poll();
            Node node=tuple.node;
            int x=tuple.vertical;
            int y=tuple.level;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.data);

            if (node.left!=null) {
                q.offer(new Tuple(node.left, x-1, y+1));
            }
            if (node.right!=null) {
                q.offer(new Tuple(node.right, x+1, y+1));
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for (TreeMap<Integer,PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size()-1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right=new Node(3);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        List<List<Integer>> ans=verticalTraversal(root);
        System.out.println(ans);
    }
}
