import java.util.Stack;

public class ReverseStringInStack {

    public static String reverse(String str){
        Stack<Character> stack = new Stack<>();
        char [] charArray = str.toCharArray();

        for(char ch : charArray)
            stack.push(ch);

        for(int i = 0; i<str.length(); i++){
            charArray[i] = stack.pop();
        }
        return new String(charArray);
    }
    public static void main(String[] args) {
        String str ="ABCD";
        System.out.println(str);
        System.out.println("reverse string:- ");
        System.out.println(reverse(str));
    }
}
