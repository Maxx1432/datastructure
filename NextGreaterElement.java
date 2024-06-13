import java.util.Stack;

public class NextGreaterElement {

    public static int [] nextGreaterElement(int [] arr){ // create a method which accept a array and return a array
        int [] result = new int[arr.length]; // create a result array with same size array which we will return
        Stack<Integer> stack = new Stack<>(); // we will LIFO property of Stack to solve the problem

        for(int i = arr.length - 1; i >= 0; i--){ //we will iterate array from last to first which help as to find the next
                                                  //greater element towards right
            if(!stack.isEmpty()){ // check stack is not empty
                while (!stack.isEmpty() && stack.peek() <= arr[i]){ // check stack is not empty and top element of
                    //stack is less than or equal to ith element of array
                    stack.pop(); // till the while condition is true we will pop from stack
                }
            }
            if (stack.isEmpty()){ // if there is no element toward right we will add -1 in result
                result[i] = -1;
            } else {
                result[i] = stack.peek(); // if there is a greater element toward right we will add the element in result
            }
            stack.push(arr[i]); // we will push array ith element in stack to check for right greater element
        }
        return result;
    }
    public static void main(String[] args) {

        int arr [] = {4,7,3,4,8,1};
        System.out.println("Before");
        for(int i: arr)
            System.out.print(i+",");
        System.out.println("\nResulted Array");
        for(int i : nextGreaterElement(arr)){
            System.out.print(i+",");
        }

    }
}
