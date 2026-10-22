class Node{
    char data;
    Node next;
    Node(char data){
        this.data=data;
        this.next=null;
    }
}
public class StackLL {
    Node top;
    public void push(char val){
        if(isEmpty()){
            top=new Node(val);
            return;
        }
        Node newNode= new Node(val);
        newNode.next=top;
        top=newNode;
    }
    public char pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return ' ';
        }
        Node newNode=top;
        top=top.next;
        return newNode.data;
    }
    public char peek(){
        if(isEmpty()){
            return ' ';
        }
        return top.data;
    }
    public boolean isEmpty(){
        return top==null;
    }
    public static void main(String[] args) {
        StackLL stack=new StackLL();
        String s="Vijay";
        char[] c=new char[s.length()];
        for(int i=0;i<s.length();i++){
            c[i]=s.charAt(i);
        }
        for(char S:c){
            stack.push(S);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
