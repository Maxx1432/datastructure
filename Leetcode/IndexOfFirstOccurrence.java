package Leetcode;

public class IndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        // Loop through haystack until there's enough room left for needle
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            // Check if the first character matches
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;

                // Compare characters one by one
                while (j < needle.length() &&
                        needle.charAt(j) == haystack.charAt(i + j)) {
                    j++;
                }

                // If all characters of needle matched, return starting index
                if (j == needle.length()) {
                    return i;
                }
            }
        }

        // If needle is not found in haystack
        return -1;
    }

    public static void main(String[] args) {
        IndexOfFirstOccurrence solution = new IndexOfFirstOccurrence();

        // Test case 1: Basic substring found
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        int result1 = solution.strStr(haystack1, needle1);
        System.out.println("Test 1 - Haystack: \"" + haystack1 + "\", Needle: \"" + needle1 + "\"");
        System.out.println("Result: " + result1 + " (Expected: 0)");
        System.out.println();

        // Test case 2: Substring not found
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        int result2 = solution.strStr(haystack2, needle2);
        System.out.println("Test 2 - Haystack: \"" + haystack2 + "\", Needle: \"" + needle2 + "\"");
        System.out.println("Result: " + result2 + " (Expected: -1)");
        System.out.println();

        // Test case 3: Needle at the end
        String haystack3 = "hello world";
        String needle3 = "world";
        int result3 = solution.strStr(haystack3, needle3);
        System.out.println("Test 3 - Haystack: \"" + haystack3 + "\", Needle: \"" + needle3 + "\"");
        System.out.println("Result: " + result3 + " (Expected: 6)");
        System.out.println();

        // Test case 5: Single character match
        String haystack5 = "a";
        String needle5 = "a";
        int result5 = solution.strStr(haystack5, needle5);
        System.out.println("Test 5 - Haystack: \"" + haystack5 + "\", Needle: \"" + needle5 + "\"");
        System.out.println("Result: " + result5 + " (Expected: 0)");
    }
}
