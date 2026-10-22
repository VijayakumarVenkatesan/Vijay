package Tree.practice;

public class SameTree {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
    }
    static boolean isSame(Node root1, Node root2){
        if(root1==null && root2==null) return true;
        if(root1!=null && root2==null) return false;
        if(root1==null && root2!=null) return false;
        if(root1.val!=root2.val) return false;
        return isSame(root1.left,root2.left)&&isSame(root1.right,root2.right);
    }
    public static void main(String[] args){
        Node root1=new Node(1);
        Node root2=new Node(1);
        System.out.println(isSame(root1, root2));
    }
}
