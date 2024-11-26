package Leetcode;

import java.util.ArrayList;
import java.util.Hashtable;

public class IntersectionOfTwoArray2 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Hashtable<Integer,Integer> nums1Map = new Hashtable<>();
        ArrayList<Integer> intersectionList = new ArrayList<>();
        for (int j : nums1) {
            if (nums1Map.containsKey(j)) {
                nums1Map.put(j, nums1Map.get(j) + 1);
            } else {
                nums1Map.put(j, 1);
            }
        }

        for(int i = 0; i < nums2.length; i++){
            if(nums1Map.containsKey(nums2[i])){
                intersectionList.add(nums2[i]);
                nums1Map.put(nums2[i], nums1Map.get(nums2[i]) - 1);
                if(nums1Map.get(nums2[i]) == 0){
                    nums1Map.remove(nums1[i]);
                }
            }
        }

        int [] result = new int [intersectionList.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = intersectionList.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        int [] nums1 = {1,2,2,1};
        int [] nums2 = {2,2};
        int [] result = intersection(nums1,nums2);
        for (int nums : result){
            System.out.print(nums+" ");
        }
    }
}
