
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

//    deletion at front end
    private ListNode front;

//    insertion at rear end.
    private ListNode rear;

//    for getting the length
    private int length;

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
    public static void main(String[] args) {

    }
}
