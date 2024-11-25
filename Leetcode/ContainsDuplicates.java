package Leetcode;

import java.util.HashSet;

public class ContainsDuplicates {
    public static boolean containsDuplicates(int [] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int number : nums){
            if(set.contains(number))
                return true;
            set.add(number);
        }
        return false;
    }
    public static void main(String[] args) {
        int [] nums = {1,2,3,1};
        System.out.println(ContainsDuplicates.containsDuplicates(nums));
    }
}
