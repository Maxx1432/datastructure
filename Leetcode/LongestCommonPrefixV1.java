package Leetcode;

public class LongestCommonPrefixV1 {
    /**
     * Finds the longest common prefix string amongst an array of strings.
     * Algorithm: Compare the first string with each subsequent string character by character
     * and keep track of the common prefix found so far.
     *
     * Time Complexity: O(S) where S is the sum of all characters in all strings
     * Space Complexity: O(1) if we don't count the output string
     *
     * @param strs array of strings to find common prefix from
     * @return the longest common prefix string, empty string if no common prefix exists
     */
    public String longestCommonPrefix(String[] strs) {
        // Initialize prefix with the first string - this will be our baseline for comparison
        String prefix = strs[0];

        // Iterate through remaining strings starting from index 1
        for(int i = 1; i < strs.length; i++){
            // If prefix becomes empty at any point, no common prefix exists
            if(prefix == "")
                return "";

            // Temporary string to store the common prefix found between current prefix and strs[i]
            String temp = "";

            // Find the minimum length to avoid index out of bounds
            // We only need to compare up to the shorter string's length
            int searchSize = Math.min(prefix.length(), strs[i].length());

            // Compare characters one by one from the beginning
            for(int j = 0; j < searchSize; j++){
                // If characters don't match, we've found the end of common prefix
                if(prefix.charAt(j) != strs[i].charAt(j)){
                    break;
                }
                // If characters match, add to temporary common prefix
                temp += prefix.charAt(j);
            }

            // Update prefix to the new common prefix found
            // This becomes progressively shorter or stays the same
            prefix = temp;
        }

        // Return the final longest common prefix
        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefixV1().longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
