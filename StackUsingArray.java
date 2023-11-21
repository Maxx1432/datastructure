public class StackUsingArray {

    private int top = -1;
    private int [] arr;

    public StackUsingArray (int length){
        arr = new int [length];
    }
    public void push(int data){
        if(isFull()){
            throw new RuntimeException("Stack is full!!!");
        }
        top++;
        arr[top] = data;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty!!!");
        }
        int result = arr[top];
        top--;
        return result;
    }

    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack is Empty!!!");
        }
        return arr[top];
    }

    private boolean isEmpty() {
        return top < 0;
    }

    private boolean isFull() {
        return arr.length == size();
    }
    private int size() {
        return top+1;
    }

    public static void main(String [] args){
        StackUsingArray sua = new StackUsingArray(3);
        sua.push(1);
        System.out.println(sua.peek());
        sua.push(4);
        System.out.println(sua.peek());
        sua.push(3);
        System.out.println(sua.peek());

        System.out.println("POP->"+sua.pop());
        System.out.println("Peek->"+sua.peek());

        System.out.println("POP->"+sua.pop());
        System.out.println("Peek->"+sua.peek());

        System.out.println("POP->"+sua.pop());
        System.out.println("Peek->"+sua.peek());
    }
}
