/* 
    null <-- [previous|data|next] <--> [previous|data|next] <--> [previous|data|next] <--> [previous|data|next] --> null
                          ^                                                                           ^
                         Head                                                                        Tail

  In Doubly Linked list The node contain address of next node as well as addess of previous node.
  We can add element, remove element and traverse the Doubly Linked List in both forward and Backward direction.
  In Doubly Linked List we can delete the node even if we don't have pointer to its previous node.
  
*/
public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

  // For creating a node in DLL
    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

  // to check the DLL conatin data or not
    public boolean isEmpty() {
        return length ==0;
    }

    public int length() {
        return length;
    }

  // Insert at the begining of the Doubly Linked List
    public void insertFirst(int value) {
      ListNode newNode = new ListNode(value);
        if(isEmpty()){
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    } 
// Insert at the end of Doubly Linked List
    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

  // Print DLL in Forward direction
    public void displayForward() {
        if(head == null)
            return;

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

  // Print DLL in Backward direction
    public void displayBackward() {
        if(tail == null)
            return;

        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data+" --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    // Delete the First node in DLL
    public ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if(head == tail){
            tail = null;
        } else {
            head.next.previous = null;
        }

        head = head.next;
        temp.next = null;
        return temp;
    }

    public static void main(String [] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(10);
        dll.insertLast(15);
        dll.insertLast(25);

        dll.displayForward();
        dll.displayBackward();

        System.out.println(dll.deleteFirst().data);
        dll.displayForward();
    }
}
