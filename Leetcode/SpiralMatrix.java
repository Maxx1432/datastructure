package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * LeetCode #54 - Spiral Matrix
 * ============================================================
 *
 * PROBLEM:
 *   Given an m x n matrix, return all elements of the matrix
 *   in spiral order (clockwise, starting from the top-left).
 *
 * APPROACH: Boundary Shrinking (Layer-by-Layer)
 * -----------------------------------------------
 *   Maintain four boundaries that close in after each direction pass:
 *     - k  : top    row    boundary  (moves down  after traversing top row)
 *     - r  : bottom row    boundary  (moves up    after traversing bottom row)
 *     - l  : left   column boundary  (moves right after traversing left column)
 *     - c  : right  column boundary  (moves left  after traversing right column)
 *
 *   Each iteration of the while-loop processes one full "layer":
 *     1. LEFT  → RIGHT : traverse top row    (row k,   cols l..c-1), then k++
 *     2. TOP   → BOTTOM: traverse right col  (col c-1, rows k..r-1), then c--
 *     3. RIGHT → LEFT  : traverse bottom row (row r-1, cols c-1..l), then r--
 *                        (only if k < r to avoid re-traversing a single row)
 *     4. BOTTOM → TOP  : traverse left col   (col l,   rows r-1..k), then l++
 *                        (only if l < c to avoid re-traversing a single col)
 *
 *   The loop continues while k < r AND l < c (i.e., there is still an
 *   unvisited interior region).
 *
 * EXAMPLE:
 *   Input : [[1,2,3],
 *            [4,5,6],
 *            [7,8,9]]
 *   Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
 *
 * TIME COMPLEXITY:  O(m * n)
 *   Every element in the m×n matrix is visited exactly once.
 *
 * SPACE COMPLEXITY: O(1)  (auxiliary)
 *   No extra data structures proportional to input size are used.
 *   The output list itself is O(m * n), but that is required by the problem
 *   and is not counted as auxiliary space.
 * ============================================================
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int i, k = 0, l = 0;
        int r = matrix.length;
        int c = matrix[0].length;

        while( k < r && l < c){
            for(i = l; i < c; i++){
                result.add(matrix[k][i]);
            }
            k++;
            for(i = k; i < r; i++ ){
                result.add(matrix[i][c - 1]);
            }
            c--;
            if(k < r){
                for(i = c - 1; i >= l; i--){
                    result.add(matrix[r - 1][i]);
                }
                r--;
            }
            if(l<c){
                for(i = r - 1; i >= k; i--){
                    result.add(matrix[i][l]);
                }
                l++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SpiralMatrix obj = new SpiralMatrix();
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> result = obj.spiralOrder(matrix);
        System.out.println(result);
    }
}
