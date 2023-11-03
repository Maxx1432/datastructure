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
        cll.createCircularLinkedList();
    }
}
