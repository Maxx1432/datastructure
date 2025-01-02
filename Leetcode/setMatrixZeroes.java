package Leetcode;

public class setMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        boolean firstColZero = false;
        boolean firstRowZero = false;

        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0)
                firstRowZero = true;
        }

        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == 0)
                firstColZero = true;
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(firstColZero){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }

        if(firstRowZero){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }

    }
    public static void main(String[] args) {
        int [][] matrix = {{1,2,0},{4,0,6},{0,8,9}};

        System.out.println("Before Zeroes");

        for(int[] arr :matrix){
            for(int  i = 0; i < arr.length; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        setZeroes(matrix);
        System.out.println();
        System.out.println("After Zeroes");

        for(int[] arr :matrix){
            for(int  i = 0; i < arr.length; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }
}
