package Collections;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Linked_List {
    public static void main(String[] args) {
        System.out.println("Linked List");
        LinkedList<Integer> list=new LinkedList<>();
        list.add(200);
        list.add(300);
        list.addFirst(100);
        list.addLast(400);
        System.out.println(list);
        System.out.println("Queue");
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println("Dequeue");
        Deque<Integer> deque=new LinkedList<>();
        deque.addFirst(200);
        deque.addFirst(100);
        deque.addLast(300);
        System.out.println(deque.peek());
    }
}