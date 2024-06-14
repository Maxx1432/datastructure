package Leetcode;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    //https://leetcode.com/problems/minimum-increment-to-make-array-unique/description/?envType=daily-question&envId=2024-06-14
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (min == nums[i]) {
                count++;
                nums[i] = nums[i] + 1;
                min = nums[i];
            } else if (min > nums[i]) {
                int dif = Math.abs(nums[i] - min);
                count += dif + 1;
                nums[i] += dif + 1;
                min = nums[i];
            } else {
                min = nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique obj1  = new MinimumIncrementToMakeArrayUnique();
        int arr[]={3,2,1,2,1,7};
        System.out.println("Before\n"+Arrays.toString(arr));
        System.out.println("Mininum move"+obj1.minIncrementForUnique(arr));
        System.out.println("after\n"+Arrays.toString(arr));
    }

}
