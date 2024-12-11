package Leetcode;

import java.util.Hashtable;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Hashtable<Integer, Integer> numberFound = new Hashtable<>();
        for(int i = 0; i < nums.length; i++){
            if(numberFound.containsKey(target - nums[i]))
                return new int[]{numberFound.get(target - nums[i]), i};
            else
                numberFound.put(nums[i], i);
        }
        return null;
    }
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;

        int[] result = twoSum(arr, target);

        for(int num : result)
            System.out.print(num+" ");
    }
}
