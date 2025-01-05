package Leetcode;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings){
            char [] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String newStr = new String(strArr);
            if(!map.containsKey(newStr)){
                map.put(newStr, new ArrayList<>());
            }
            map.get(newStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String [] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strings);
        System.out.println(result);
    }
}
