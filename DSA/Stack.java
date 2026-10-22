public class Stack {
    int[] arr;
    int top,capacity;
    public Stack(int size){
        arr=new int[size];
        capacity=size;
        top=-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==capacity-1;
    }
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top];
    }
    public void push(int val){
        if(isFull()){
            System.out.println("Stack overflow!");
            return;
        }
        arr[++top]=val;
        System.out.println(val+" is pushed to stack");
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty!");
            return -1;
        }
        return arr[top--];
    }
    public static void main(String[] args) {
        Stack stack=new Stack(5);
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        stack.push(15);
        stack.push(16);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
