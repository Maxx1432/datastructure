package Leetcode;

public class PlusOne {

    public static int [] plusOne(int [] digit){
        int currentDigit = digit.length -1;
        while(digit[currentDigit] == 9){
            if(currentDigit == 0){
                int [] numsAns = new int[digit.length + 1];
                numsAns[0] = 1;
                return numsAns;
            }
            digit[currentDigit] = 0;
            currentDigit--;
        }
        digit[currentDigit]++;


        return digit;
    }
    public static void main(String[] args) {
        int [] arr = {9,9,9};
        arr = plusOne(arr);
        for(int num : arr)
            System.out.print(num+" ");
    }
}
