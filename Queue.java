import java.util.NoSuchElementException;

/*
    [data|next] ---> [data|next] ---> [data|next] ---> [data|next] ---> null
         ^                                                  ^
       Front                                               Rear

  Queue is linear data structure used for storing the data.
  it's an ordered list in which insertion are done at one end, called rear and deletion are done at other end called as front.
  The first element inserted is the first one to be deleted
  Hence, it is called as FIRST IN FIST OUT(FIFO) list.

*/
public class Queue {

//    deletion at front end / point to the first element
    private ListNode front;

//    insertion at rear end / point to the last element
    private ListNode rear;

//    for getting the length
    private int length;

//    creating a constructor to assign default values
    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

//    For creating a node
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

//    return length of the Queue
    public int length(){
        return length;
    }

//  check queue is empty or not.
    public boolean isEmpty(){
        return length == 0;
    }

//    Create a method to insert element in the queue
    public void enQueue(int data){
        ListNode temp = new ListNode(data);
        if(isEmpty()){
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

//    create a method to delete the element from front of queue
    public int deQueue(){
        if(isEmpty()){
            throw new NoSuchElementException("queue is empty");
        }
        int result = front.data;
        front = front.next;
        if(front == null){
            rear = null;
        }
        length--;
        return result;
    }

//    return the first element in the queue
    public int first(){
        if(isEmpty()){
            throw new NoSuchElementException("queue is empty");
        }
        return front.data;
    }

//    return the last element in the queue
    public int last() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.data;
    }

//    Method to print the queue;
    public void print(){
        if(isEmpty()){
            return;
        }
        ListNode current = front;
        while (current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enQueue(10);
        queue.enQueue(15);
        queue.enQueue(20);

        queue.print();

        System.out.println("First Element->"+queue.first());
        System.out.println("First Element->"+queue.last());


        System.out.println("Element removed->"+queue.deQueue());
        queue.print();
        System.out.println("Element removed->"+queue.deQueue());
        queue.print();
        System.out.println("Element removed->"+queue.deQueue());


        queue.print();
    }
}
