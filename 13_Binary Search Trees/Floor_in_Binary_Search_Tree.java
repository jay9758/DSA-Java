//https://www.geeksforgeeks.org/problems/floor-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-bst

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
public class Floor_in_Binary_Search_Tree {

    public static int floorOfValue(Node root,int v){
        int floor=-1;
        while (root!=null) {
            if (root.data==v) {
                floor=root.data;
                return floor;
            }
            if (root.data<v) {
                floor=root.data;
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        Node root=new Node(8);
        root.left=new Node(5);
        root.left.left=new Node(4);
        root.left.right=new Node(7);
        root.right=new Node(12);
        root.right.left=new Node(10);
        root.right.right=new Node(14);
        
        int v=11;

        int ceil=floorOfValue(root,v);
        System.out.println(ceil);
    }
}
