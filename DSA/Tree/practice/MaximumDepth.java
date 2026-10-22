package Tree.practice;

public class MaximumDepth {
    static class Node{
        int val;
        Node right;
        Node left;
        Node(int val){
            this.val=val;
        }
    }
    static int maxDepth(Node root){
        if(root==null) return 0;
        int right=maxDepth(root.right);
        int left=maxDepth(root.left);
        return Math.max(right,left)+1;
    }
    public static void main(String[] args){
        Node root=new Node(1);
        root.right=new Node(2);
        root.left= new Node(3);
        root.right.right= new Node(4);
        root.left.left= new Node(5);
        root.left.left.left=new Node(6);
        System.out.println(maxDepth(root));
    }
}
