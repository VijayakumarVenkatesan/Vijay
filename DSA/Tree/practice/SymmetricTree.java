package Tree.practice;

public class SymmetricTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    static boolean compare(Node left,Node right){
        if(left==null && right==null) return true;
        if(left!=null && right==null) return false;
        if(left==null && right!=null) return false;
        if(left.val!=right.val) return false;
        return compare(left.left, right.right)&&compare(left.right, right.left);
    }
    static boolean isSymmetric(Node root){
        if(root==null) return true;
        return compare(root.left, root.right);
    }
    public static void main(String[] args){
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(2);
        System.out.println(isSymmetric(root));
    }
}
