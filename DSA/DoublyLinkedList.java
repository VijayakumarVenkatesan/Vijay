public class DoublyLinkedList{
    static class Node {
        Node prev;
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    Node head;
    void append(int data){
        if(head==null){
            head=new Node(data);
            return;
        }
        Node last=head;
        if(last.next!=null){
            last=last.next;
        }
        Node newNode=new Node(data);
        last.next=newNode;
        newNode.prev=last;
    }
    void prepend(int data){
        if(head==null){
            head=new Node(data);
            return;
        }
        Node newNode=new Node(data);
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
    }
    void printForward(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        Node temp=head;
        System.out.print("\nNull");
        while(temp!=null){
            System.out.print(" <-> "+temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.print("Null\n");
    }
    void printBackward(){
        if(head==null){
            System.out.println("List is empty!");
            return;
        }
        Node last=head;
        System.out.print("\nNull");
        while(last.next!=null){
            last=last.next;
        }
        while(last!=null){
            System.out.print(" <-> "+last.data+" <-> ");
            last=last.prev;
        }
        System.out.print("Null\n");
    }
    int elementAt(int pos){
        Node temp=head;
        int Pos=1;
        while(Pos!=pos){
            temp=temp.next;
            ++Pos;
        }
        return temp.data;
    }
    static DoublyLinkedList sum(DoublyLinkedList l1, DoublyLinkedList l2) {
        Node n1 = l1.head;
        Node n2 = l2.head;
        while(n1!=null&&n1.next!=null) n1=n1.next;
        while(n2!=null&&n2.next!=null) n2=n2.next;
        DoublyLinkedList Ans=new DoublyLinkedList();
        int carry=0;
        int dummy=0;
        while(n1!=null||n2!=null){
            int val1=(n1!=null)?n1.data:0;
            int val2=(n2!=null)?n2.data:0;
            int sum=carry+val1+val2;
            dummy=sum;
            carry=sum/10;
            sum=sum%10;
            Ans.prepend(sum);
            n1 = (n1 != null) ? n1.prev : null;
            n2 = (n2 != null) ? n2.prev : null;
        }
        if(dummy>9) Ans.prepend(dummy/10);
        return Ans;
    }
    int length(){
        Node temp=head;
        int length=0;
        while(temp!=null){
            temp=temp.next;
            ++length;
        }
        return length;
    }
    void insertAt(int data,int pos,int max){
        if(pos<1||pos>max){
            System.out.println("Invalid position!");
            return;
        }
        Node temp=head;
        int position=1;
        while(position<pos){
            temp=temp.next;
            position+=1;
        }
        System.out.println(temp.data+" Temp");
        Node newNode=new Node(data);
        newNode.next=temp.next;
        newNode.prev=temp;
        temp.next=newNode;
    }
    public static void main(String[] args) {
        DoublyLinkedList dll1=new DoublyLinkedList();
        dll1.append(1);
        dll1.append(2);
        dll1.append(0);
        DoublyLinkedList dll2=new DoublyLinkedList();
        dll2.append(9);
        dll2.append(1);
        dll2.append(0);
        dll1.printForward();
        dll1.insertAt(3,3,dll1.length());
        dll1.printForward();
    }
}