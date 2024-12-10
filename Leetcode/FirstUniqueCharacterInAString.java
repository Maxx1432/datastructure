package Leetcode;

public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s){
        //Using HashTable
        // Hashtable<Character, Integer> freq = new Hashtable<>();

        // for(char ch : s.toCharArray()){
        //     if(!freq.containsKey(ch)){
        //         freq.put(ch,1);
        //     } else {
        //         freq.put(ch, freq.get(ch) + 1);
        //     }
        // }

        // for(int i = 0; i < s.length(); i++){
        //     if(freq.get(s.charAt(i)) == 1)
        //         return i;
        // }

        //Using Freq Array
        int [] charCount = new int [26];
        for(int i = 0; i < s.length(); i++){
            charCount[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++){
            if(charCount[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(firstUniqChar(str));
    }
}
