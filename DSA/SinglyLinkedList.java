public class SinglyLinkedList {
    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of list
    Node head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at end
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert at position (1-based index)
    public void insertAtPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Position should be >= 1");
            return;
        }

        if (position == 1) {
            insertAtBeginning(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;  //temp=1

        for (int i = 1; i < position - 1 && temp != null; i++) {  //1<2 2<2
            temp = temp.next;                                     //2           element before the position
        }

        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newNode.next = temp.next;    //val(13).next=3(2.next)                   the current position node is stored on newnode'next
        temp.next = newNode;         //2.next=13                                previous node's next is new
    }

    // Delete by value
    public void deleteByValue(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Value not found");
            return;
        }

        temp.next = temp.next.next;
    }

    // Delete at position (1-based index)
    public void deleteAtPosition(int position) {
        if (position < 1) {
            System.out.println("Position should be >= 1");
            return;
        }

        if (head == null) return;

        if (position == 1) {
            head = head.next;
            return;
        }

        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }

        temp.next = temp.next.next;
    }

    // Search for value
    public boolean search(int key) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtBeginning(11);
        list.insertAtEnd(12);
        list.insertAtEnd(14);
        list.display();
        list.insertAtPosition(13,3);
        list.display();
    }
}
