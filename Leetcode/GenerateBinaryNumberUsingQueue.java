package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
/*
* this program will generate N Binary numbers using queue
*                       1
*                  10       11
*               100  101  110 111
*
* */
public class GenerateBinaryNumberUsingQueue {

    public static String [] generateBinaryNumber(int n){
        String [] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1"); // first we offer 1 to queue
        for(int i = 0; i < n; i++){
            result[i] = queue.poll(); // give it to our result array
            String n1 = result[i] + "0"; // create the value by appending 0 to result[i] value
            String n2 = result[i] + "1"; // create the value by appending 1 to result[i] value
            queue.offer(n1); // assign the value to queue
            queue.offer(n2);
        }
        return result;
    }
    public static void main(String[] args) {
        String [] result = generateBinaryNumber(15);
        for(String str : result){
            System.out.print(str);
            System.out.print(", ");
        }
    }
}
