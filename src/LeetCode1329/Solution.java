package LeetCode1329;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    public int[][] diagonalSort(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            List<point> ans = new ArrayList();
            ans = collect(i, 0, mat.length, mat[i].length, ans, mat);
            Collections.sort(ans);
            for (point an : ans) {
                mat[an.i][an.j] = an.val;
            }
        }
        for (int i = 1; i < mat[0].length; i++) {
            List<point> ans ;
            ans = collect(0, i, mat.length, mat[0].length, new ArrayList(), mat);
            Collections.sort(ans);
            for (point an : ans) {
                mat[an.i][an.j] = an.val;
            }
        }
        
        return mat;
    }

    public List<point> collect(int r, int c, int n, int m, List<point> ans, int[][] mat) {
        if (r >= n || c >= m) {
            return ans;
        }

        ans.add(new point(r, c, mat[r][c]));
        return collect(r + 1, c + 1, n, m, ans, mat);
    }

    public static void main(String[] args) {
        int mat[][] = {{3,3,1,1},{2,2,1,2},{1,1,1,2}};
        
        mat = new Solution().diagonalSort(mat);
        
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println("");
        }
    }
}

class point implements Comparable<point> {

    int i, j, val;

    public point(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    @Override
    public int compareTo(point t) {
        return val - t.val;
    }

}
