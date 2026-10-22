package Tree.practice;

public class InvertBT {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    static void invert(Node root){
        if(root==null) return;
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
        invert(root.left);
        invert(root.right);
    }
    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left= new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        invert(root);
    }
}
