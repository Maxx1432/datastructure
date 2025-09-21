package Leetcode;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Finds the length of the longest substring without repeating characters
     * Uses sliding window technique with two pointers (left and right)
     * Time Complexity: O(n) where n is the length of the string
     * Space Complexity: O(min(m,n)) where m is the size of the charset
     */
    public static int lengthOfLongestSubstring(String s) {
        // HashSet to keep track of characters in the current window
        HashSet<Character> characterSeen = new HashSet<>();

        // Variable to store the maximum length found so far
        int maxLength = 0;

        // Left pointer of the sliding window
        int l = 0;

        // Right pointer of the sliding window - iterates through the string
        for(int r = 0; r < s.length(); r++){
            // Try to add the current character to the set
            // If add() returns false, it means the character is already in the set (duplicate found)
            while(!characterSeen.add(s.charAt(r))){
                // Remove characters from the left side of the window until the duplicate is removed
                // This shrinks the window from the left until we have all unique characters again
                characterSeen.remove(s.charAt(l++));
            }

            // Update maxLength with the current window size (r - l + 1)
            // This represents the length of the current substring without repeating characters
            maxLength = Math.max(maxLength , r - l + 1);
        }

        // Return the maximum length found
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result); // Output: 3
    }
}
