package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 12/07/20
 */
public class LinkedListDemo
{
    private class Node
    {
        int data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    private void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "\t");
            temp = temp.next;
        }
    }

    private void addLast(int data) {
        //ceate a node
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        //attach the node
        if (this.size >= 1) {
            this.tail.next = newNode;
        }

        //summary object
        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
            size++;
        } else {
            tail = newNode;
            size++;
        }

        /*if (this.head == null){
            this.head = newNode;
            this.tail = this.head;
        }else{
            Node temp = this.head;
            while (temp.next !=null){
                temp = temp.next;
            }
            temp.next = newNode;
        }*/
    }

    public static void main(String[] args) {
        LinkedListDemo listDemo = new LinkedListDemo();
        listDemo.addLast(10);
        listDemo.addLast(80);
        listDemo.addLast(30);
        listDemo.addLast(90);
        listDemo.addLast(40);
        listDemo.addLast(50);
        listDemo.addLast(70);
        listDemo.display();
    }
}
