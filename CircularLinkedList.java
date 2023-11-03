/*
In Circular Linked List the last node points to first node and not null.
Instead of head, we keep track of last node in Circular Singly Linked List

                                                                      Last
                                                                        V
  --> [Data|addreess] --> [Data|addreess] --> [Data|addreess] --> [Data|addreess] --
  | <-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- |

*/
  
public class CircularLinkedList {

    private ListNode last;
    private int length;

    private class ListNode{
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public CircularLinkedList(){
        last = null;
        length = 0;
    }

    public int length(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }

  // To insert Node at starting of List
      public void insertFirst(int data) {
        ListNode temp = new ListNode(data);
        if(last == null)
        {
            last = temp;
        } else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

  // insert Node at the end of the Circular Linked List
  public void insertLast(int data) {
        ListNode temp = new ListNode(data);
        if(last == null) {
            last = temp;
            last.next = temp;
        } else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

  // To Display the Circular Linked List
  public void display(){
        if(last == null){
            return;
        }
        ListNode first = last.next;
        while(first != last) {
            System.out.print(first.data+"-->");
            first = first.next;
        }
        System.out.print(first.data+" ");
    }

    // Create node and connect them to make a Circular linked list
    // assign the last
    public void createCircularLinkedList(){

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(10);
        ListNode third = new ListNode(100);
        ListNode fourth = new ListNode(1000);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;

    }

    public static void main(String [] args){

        CircularLinkedList cll = new CircularLinkedList();
        // cll.createCircularLinkedList();

        cll.insertFirst(1000);
        cll.insertFirst(100);
        cll.insertFirst(10);
        cll.insertFirst(1);

        cll.insertLast(10000);

        cll.display();
    }
}
