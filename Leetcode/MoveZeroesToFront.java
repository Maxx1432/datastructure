package Leetcode;

public class MoveZeroesToFront {
    public static int[] moveZeroesToFront(int [] arr){
        int i = arr.length - 1;
        int j = i - 1;
        while(j >=0){
            if(arr[i] != 0){
                i--;
                j--;
            } else if(arr[j] == 0){
                j--;
            } else {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i--;
                j--;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int [] arr = {0,-1,0,1,4,5,0,5,0};
        int [] newArr = moveZeroesToFront(arr);

        for(int num : newArr){
            System.out.print(num+" ");
        }
    }
}
