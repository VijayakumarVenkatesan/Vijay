public class BinaryTree{
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
        }
    }
    Node root;
    void inOrder(Node node){
        if(node==null) return;
        inOrder(node.left);
        System.out.print(node.data+" ");
        inOrder(node.right);
    }
    void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }
    void postOrder(Node node){
        if(node==null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    public static void main(String[] args) {
        BinaryTree node=new BinaryTree();
        node.root=new Node(11);
        node.root.left=new Node(12);
        node.root.right=new Node(13);
        node.inOrder(node.root);
        System.out.println();
        node.preOrder(node.root);
        System.out.println();
        node.postOrder(node.root);
        System.out.println();
    }
}
