package Leetcode;

import java.util.Arrays;

public class LongestCommonPrefixV2 {
    /**
     * Finds the longest common prefix string amongst an array of strings using sorting approach.
     * Algorithm: Sort the array lexicographically, then compare only the first and last strings.
     * Since sorting arranges strings in alphabetical order, if there's a common prefix among all strings,
     * it will definitely be present between the first (lexicographically smallest) and last (lexicographically largest) strings.
     *
     * Time Complexity: O(n * m * log n) where n is number of strings and m is average length of strings
     * Space Complexity: O(1) if we don't count the sorting space
     *
     * @param strs array of strings to find common prefix from
     * @return the longest common prefix string, empty string if no common prefix exists
     */
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if array has less than 1 element, return the first element
        // Note: This condition should probably check for empty array (length == 0) instead
        if(strs.length<1)
            return strs[0];

        // Sort the array lexicographically (alphabetically)
        // After sorting, the first and last elements will be the most different
        // If they share a common prefix, all elements in between will also share it
        Arrays.sort(strs);

        // Initialize index to track how many characters match from the beginning
        int i=0;

        // Compare characters of first string (lexicographically smallest) with
        // last string (lexicographically largest) character by character
        // Continue while:
        // 1. We haven't reached the end of the first string
        // 2. Characters at current position match in both first and last strings
        while(i<strs[0].length() && strs[0].charAt(i) == strs[strs.length-1].charAt(i))
            i++;

        // Return the substring from beginning up to the last matching character
        // This represents the longest common prefix among all strings
        return strs[0].substring(0,i);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefixV2().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
