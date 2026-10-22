public class LinkedList {
    public static class listNode{
        int val;
        listNode next;
        listNode(){}
        listNode(int val){this.val=val;}
        listNode(int val,listNode next){
            this.val=val;
            this.next=next;
        }
    }
    public static void main(String[] args) {
        listNode l1=new listNode(1);
        listNode l2=new listNode(2);
        listNode l3=new listNode(3);
        listNode l4=new listNode(4);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;
        while(l1!=null){
            System.out.print(l1.val+" ");
            l1=(l1.next!=null)?l1.next:null;
        }
        System.out.println();
    }
}
