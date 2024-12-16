package Leetcode;

public class RotateImage {

    public static void rotate(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

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
