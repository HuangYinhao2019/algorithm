package leetcode.weekly.weeklym5d03;/**
 * @description T4
 * @author liusandao
 * @date 2020-5-4 13:18
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-04 13:18
 */

public class T4 {

    private int count;
    public int kthSmallest(int[][] mat, int k) {
        int n = mat[0].length;
        int m = mat.length;
        int left = 0;
        int right = 0;
        for (int i = 0; i < m; i++) {
            left += mat[i][0];
            right += mat[i][n - 1];
        }
        int init = left;
        while (left < right) {
            int mid = left + (right - left) / 2;
            count = 1;
            dfs(mid, 0, init, k, mat);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private void dfs(int mid, int index, int sum, int k, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (sum > mid || index == m || count > k) {
            return;
        }
        dfs(mid, index + 1, sum, k, mat);
        for (int i = 1; i < n; i++) {
            if (sum + mat[index][i] - mat[index][0] <= mid) {
                count++;
                dfs(mid, index + 1, sum + mat[index][i] - mat[index][0], k, mat);
            } else {
                break;
            }
        }
    }
}


