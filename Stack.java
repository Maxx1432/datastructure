import java.util.EmptyStackException;

public class Stack {
  
    private ListNode top;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public Stack(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    // To insert a element in the stack
    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    // To remove the element from stack
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    // To check the top element of stack
    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            return top.data;
        }
    }

    public static void main(String [] args){

        Stack stack = new Stack();
        stack.push(1);
        stack.push(10);
        stack.push(100);
        stack.push(1000);

        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());

    }
}
