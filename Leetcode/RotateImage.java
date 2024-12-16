package Leetcode;

public class RotateImage {

    public static void rotate(int[][] matrix) {

        //first we transpose the matrix
        /*
        [1 2 3]        [1 4 7]
        [4 5 6]   <==> [2 5 8]
        [7 8 9]        [3 6 9]
         */

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //after the transpose we rotate the rows
        /*
        [1 4 7]      [7 4 1]
        [2 5 8] <==> [8 5 2]
        [3 6 9]      [9 6 3]
         */

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - j - 1];
                matrix[i][matrix[0].length - j - 1] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println("Before rotate");

        for(int[] arr :matrix){
            for(int  i = 0; i < arr.length; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        rotate(matrix);
        System.out.println();
        System.out.println("After Rotate");

        for(int[] arr :matrix){
            for(int  i = 0; i < arr.length; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

    }
}
