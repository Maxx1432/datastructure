package Leetcode.BinarySearch;
class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;

        while(right >= left){
            int mid = left + (right - left)/2;
            if(target >= letters[mid]){
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        return letters[left % letters.length];
    }
}

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char [] arr = {'e','e','e','e','e','e','n','n','n','n'};
        System.out.println(sol.nextGreatestLetter(arr, 'e'));
    }

}
