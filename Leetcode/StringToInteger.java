package Leetcode;

public class StringToInteger {
    public int myAtoi(String s) {
        // Remove leading and trailing whitespaces
        String trimmedString = s.trim();

        // If the string is empty after trimming, return 0
        if (trimmedString.isEmpty())
            return 0;

        int index = 0;      // Pointer to traverse the string
        int sign = 1;       // Default sign is positive
        int answer = 0;     // Store the numeric value

        // Check if the first character is a sign
        if (trimmedString.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (trimmedString.charAt(index) == '+') {
            index++;
        }

        // Process each digit character
        while (index < trimmedString.length() && Character.isDigit(trimmedString.charAt(index))) {
            int digit = trimmedString.charAt(index) - '0';

            // Check for overflow before multiplying and adding
            if (answer > Integer.MAX_VALUE / 10 ||
                    (answer == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            // Update the answer with the current digit
            answer = answer * 10 + digit;
            index++;
        }

        // Return the final result with the correct sign
        return answer * sign;
    }

    public static void main(String[] args) {
        StringToInteger solution = new StringToInteger();
        String s = "   -42";
        int result = solution.myAtoi(s);
        System.out.println(result); // Output: -42
    }
}
