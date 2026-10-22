package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    Node root;
    public void insert(int val) {
        root=insert(root,val);
    }
    private Node insert(Node root,int val) {
        if(root==null){
            return new Node(val);
        }
        if(val<root.val){
            root.left=insert(root.left,val);
        } else if(val>root.val) {
            root.right=insert(root.right,val);
        }
        return root;
    }
    public boolean exist(int val){
        return exist(root,val);
    }
    private boolean exist(Node root,int val){
        if(root==null) return false;
        else if(root.val==val) return true;
        else if(root.val<val) return exist(root.right,val);
        else return exist(root.left,val);
    }
    public int findMin(){
        return findMin(root);
    }
    private int findMin(Node root){
        if(root.left!=null) return findMin(root.left);
        else return root.val;
    }
    public int findMax(){
        return findMax(root);
    }
    private int findMax(Node root){
        if(root.right!=null) return findMax(root.right);
        else return root.val;
    }
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node root){
        if(root==null) return;
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node root){
        if(root==null)return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node root){
        if(root==null)return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    public void bfs(){
        bfs(root);
    }
    private void bfs(Node root){
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
        BST bst1=new BST();
        bst1.insert(10);
        bst1.insert(20);
        bst1.insert(30);
        bst1.insert(50);
        bst1.insert(40);
        bst1.inOrder();
    }
}


/*
            10
                20
                    30
                        50
                    40
 */