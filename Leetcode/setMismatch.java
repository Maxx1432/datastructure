package Leetcode;

import java.util.Arrays;

public class setMismatch {

    public static int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int duplicate = -1, missing = -1;

        // Mark visited numbers by negating the value at the corresponding index
        for (int i = 0; i < n; i++) {
            int index = Math.abs(nums[i]) - 1; // Use absolute value to handle already-negated numbers
            if (nums[index] < 0) {
                duplicate = Math.abs(nums[i]); // If already negative, it's the duplicate
            } else {
                nums[index] = -nums[index]; // Mark as visited
            }
        }

        // Find the missing number by checking which index has a positive value
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                missing = i + 1; // Missing number is the 1-based index
            }
        }

        return new int[] { duplicate, missing };
    }
    public static void main(String[] args) {
        int arr [] = {1,2,2,4};

        arr = findErrorNums(arr);
        System.out.println(Arrays.toString(arr));
    }
}
