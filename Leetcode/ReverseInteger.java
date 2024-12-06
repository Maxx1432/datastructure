package Leetcode;

public class ReverseInteger {

    public static int reverse(int x){
        int result = 0;

        while(x != 0){
            int rem = x % 10;
            int temp = (result * 10) + rem;

            if((temp - rem) / 10 != result )
                return 0;

            x = x / 10;
            result = temp;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(1239857479));
    }
}
