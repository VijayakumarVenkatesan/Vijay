package Tree;


import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    public static void preOrder(Node root){
        if(root==null) return;
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){
        if(root==null) return;
        preOrder(root.left);
        System.out.println(root.val);
        preOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root==null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.println(root.val);
    }
    public static void bfs(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node=queue.poll();
            System.out.print(node.val+" ");
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        System.out.println("Depth First Search");
        System.out.println("Pre order traversal");
        preOrder(root);
        System.out.println("In order traversal");
        inOrder(root);
        System.out.println("Post order traversal");
        postOrder(root);
        System.out.println("Breadth First Search");
        bfs(root);
    }
}
