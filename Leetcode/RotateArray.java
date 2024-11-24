package Leetcode;

public class RotateArray {
    private void rotate(int[] nums, int k) {
        //input -> [1,2,3,4,5,6,7]
        //output ->[5,6,7,1,2,3,4]

        //if k == nums.length then it will bring back the array to the normal position
        k  = k % nums.length; // to make k for the specific amount of rotation

        //[1,2,3,4,5,6,7] - > [7,6,5,4,3,2,1]
        reverse(nums,0,nums.length - 1);

        //[7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
        reverse(nums,0,k - 1);

        //[5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
        reverse(nums,k,nums.length - 1);
    }

    public void reverse(int [] nums, int start, int end){
        int temp;
        while(start < end){
            temp =  nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public void print(int [] nums){
        for(int temp : nums){
            System.out.print(temp);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        RotateArray obj  = new RotateArray();
        int[] nums ={1,2,3,4,5,6,7};
        int k = 3;
        obj.print(nums);
        obj.rotate(nums,k);
        obj.print(nums);
    }
}
