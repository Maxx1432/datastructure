package Leetcode;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        if(nums.length < 2)
            return;

        int pointLeft = 0;
        int pointRight = 1;

        while(pointRight < nums.length){
            if(nums[pointLeft] != 0){
                pointLeft++;
                pointRight++;
            } else if(nums[pointRight] == 0){
                pointRight++;
            } else {
                int temp = nums[pointRight];
                nums[pointRight] = nums[pointLeft];
                nums[pointLeft] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int arr [] ={0,1,0,3,12};
        moveZeroes(arr);
        for(int num : arr)
            System.out.print(num+" ");
    }
}
