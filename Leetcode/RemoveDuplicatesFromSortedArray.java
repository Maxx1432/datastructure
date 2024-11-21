package Leetcode;

public class RemoveDuplicatesFromSortedArray {
    // Input Array [0,0,1,1,1,2,2,3,3,4]
    // Output Array [0,1,2,3,4,_,_,_,_,_]

    public static void main(String[] args) {
        int [] numbers = {0,0,1,1,1,2,2,3,3,4};

        int lastUniqueIndex = 0;
        for(int i = 1; i < numbers.length; i++)
        {
            if(numbers[lastUniqueIndex] != numbers[i]){
                numbers[lastUniqueIndex + 1] = numbers[i];
                lastUniqueIndex++;
            }
        }

        for (int number : numbers) System.out.print(number + " ");
    }
}
