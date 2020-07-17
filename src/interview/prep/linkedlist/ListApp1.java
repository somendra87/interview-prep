package interview.prep.linkedlist;

/**
 * @author somendraprakash created on 18/07/20
 */
public class ListApp1
{
    private static class Node
    {
        int data;
        Node link;

        Node(int data) {
            this.data = data;
            this.link = null;
        }
    }

    private Node head;

    private void add(int data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = node;
        } else {
            Node temp = this.head;
            while (temp.link != null) {
                temp = temp.link;
            }
            temp.link = node;
        }
    }

    private void displayList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " \t");
            temp = temp.link;
        }
        System.out.println();
    }

    private int getKthElementFromLast(int k) {
        Node temp = this.head;
        // take two pointer approach
        // movie the friend pointer ahead equal to the value of k
        Node friend = this.head;
        Node me = this.head;

        int index = 0;
        while (index < k - 1) {
            friend = friend.link;
            index++;
        }
        while (friend.link != null) {
            friend = friend.link;
            me = me.link;
        }
        return me.data;
    }

    private Node getMid(){
        Node friend = this.head;
        Node me = this.head;

        while (friend != null && friend.link != null){
            friend = friend.link.link;
            me = me.link;
        }
        return me;
    }



    public static void main(String[] args) {
        ListApp1 list = new ListApp1();
        list.add(10);
        list.add(80);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(70);
        list.add(90);
        list.displayList();

        Node mid = list.getMid();
        System.out.println("Mid element of the list is : "+mid.data);

        int k = 3;
        int kthElementFromLast = list.getKthElementFromLast(k);
        System.out.println(k + " element from last is : "+ kthElementFromLast);
    }
}
