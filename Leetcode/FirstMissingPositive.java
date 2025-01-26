package Leetcode;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place each number in its correct position if possible using the cyclic sort
        // If the number is negative we increase the pointer
        // we the number is greater than array length, will put it in the end
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                // Swap nums[i] with the number at its correct position
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // Check for the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If all positions are filled correctly, the missing number is n + 1
        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr ={-1,-2,1,5,0,2,3,4};
        System.out.println(firstMissingPositive(arr));
    }
}
