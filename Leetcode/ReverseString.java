package Leetcode;

public class ReverseString {
    public static void reverseString(char [] s){
        for(int i = 0; i < s.length / 2; i++){
            char ch = s[i];
            s[i] = s[s.length - 1 -i];
            s[s.length - 1 -i] = ch;
        }
    }
    public static void main(String[] args) {
        char [] s ={'h','e','l','l','o'};
        reverseString(s);
        for(char ch : s)
            System.out.print(ch+",");
    }
}
