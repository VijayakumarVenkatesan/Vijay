public class CircularSinglyLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    Node head=null;
    Node tail=null;
    void append(int val){
        Node newNode=new Node(val);
        if(head==null){
            head=newNode;
            tail=newNode;
            tail.next=head;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        tail.next=head;
    }
    void display(){
        if(head==null){
            System.out.println("Circular linked list is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=(temp.next!=head)?temp.next:null;
        }
        System.out.println();
    }
    void deleteElement(int val){
        if(head==null){
            System.out.println("Circular linked list is empty");
            return;
        }
        Node temp=head;
        if(temp.data==val){
            if(head==tail){
                head=null;
                tail=null;
                return;
            }
            head=head.next;
            tail.next=head;
            return;
        }
        while(temp!=null){
            if(temp.next.data==val){
                temp.next=temp.next.next;
                return;
            }
            temp=(temp.next!=head)?temp.next:null;
        }
        System.out.println("The "+val+" is not present in the list!");
    }
    void deleteAt(int pos,int max){
        if(head==null){
            System.out.println("Circular linked list is empty");
            return;
        }
        if(pos>max){
            System.out.println("Position is out of bound of the list!");
            return;
        }
        Node temp=head;
        int position=1;
        while(temp!=null){
            if(position==pos-1){
                temp.next=temp.next.next;
                return;
            }
            ++position;
            temp=(temp.next!=head)?temp.next:null;
        }

    }
    int length(){
        Node temp=head;
        int len=0;
        while(temp!=null){
            ++len;
            temp=(temp.next!=head)?temp.next:null;
        }
        return len;
    }
    public static void main(String[] args) {
        CircularSinglyLL cll=new CircularSinglyLL();
        cll.append(11);
        cll.append(12);
        cll.append(13);
        cll.append(14);
        cll.display();
        cll.deleteAt(3,cll.length());
        cll.display();
        cll.deleteElement(11);
        cll.display();
        cll.deleteElement(12);
        cll.display();
        cll.deleteElement(14);
        cll.display();
    }
}
