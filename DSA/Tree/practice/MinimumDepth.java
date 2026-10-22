package Tree.practice;

public class MinimumDepth {
    static class Node{
        int val;
        Node right;
        Node left;
        Node(int val){
            this.val=val;
        }
    }
    static int minDepth(Node root){
        if(root==null) return 0;
        if(root.right==null) return(minDepth(root.left));
        if(root.left==null) return(minDepth(root.right));
        return Math.min(minDepth(root.left), minDepth(root.right))+1;
    }
    public static void main(String[] args){
        Node root=new Node(1);
        root.right=new Node(2);
        root.left= new Node(3);
        root.right.right= new Node(4);
        root.left.left= new Node(5);
        root.left.left.left=new Node(6);
        System.out.println(minDepth(root));
    }
}
