//http://geeksforgeeks.org/problems/binary-tree-representation/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=binary-tree-representation

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
class Create_binary_tree {

    public static Node createTree(int[] arr){
        int n=arr.length;
        if (n<=0) {
            return null;
        }
        return buildTree(arr,0,n);
    }
    public static Node buildTree(int[] arr,int i,int n){
        if (i>=n) {
            return null;
        }
        Node root=new Node(arr[i]);
        root.left=buildTree(arr, 2 * i+1, n);
        root.right=buildTree(arr, 2 * i+2, n);
        return root;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};

        Node root=createTree(arr);
        System.out.println(root.data);
        System.out.println(root.left.data);
    }
}