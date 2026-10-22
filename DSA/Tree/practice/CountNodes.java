package Tree.practice;

public class CountNodes {
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val=val;
        }
        static int count(Node root){
            if(root==null) return 0;
            return count(root.left)+1+count(root.right);
        }
        public static void main(String[] args){
            Node root=new Node(1);
            root.left=new Node(2);
            root.right=new Node(3);
            root.left.left=new Node(4);
            System.out.println(count(root));
        }
    }
}
