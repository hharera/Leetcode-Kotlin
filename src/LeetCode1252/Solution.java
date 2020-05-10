
package LeetCode1252;

class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        int rows[] = new int[n];
        int cols[] = new int[m];

        int[][] grid = new int[n][m];

        for (int i = 0; i < indices.length ; i++) {
            rows[indices[i][0]]++;
            cols[indices[i][1]]++;
        }

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] += rows[i];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[j][i] += cols[i];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] % 2 != 0) {
                    ans ++;
                }
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int grid [][] = {{0,1},{1,1}};
        System.out.println(new Solution().oddCells(2, 3, grid));
    }

}
