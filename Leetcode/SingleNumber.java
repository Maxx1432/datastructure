package Leetcode;

public class SingleNumber {

    //Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    //
    //You must implement a solution with a linear runtime complexity and use only constant extra space.

    private static int singleNumber(int[] nums) {
        int finder = 0;
        for(int number : nums)
            finder ^= number;

        return finder;
    }
    public static void main(String[] args) {
        int [] nums = {4,1,2,1,2};
        System.out.println(SingleNumber.singleNumber(nums));
    }
}
