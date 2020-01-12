package leetcode.weeklym1d12;

public class Solutionm1d12 {
    public int[] getNoZeroIntegers(int n) {
        int []ans = new int[]{1,n-1};
        for (int i = 1; i < n; i++) {
            int k = i;
            int p = n - i;
            boolean flag = false;
            while(k != 0){
                if (k % 10 == 0){
                    flag = true;
                    break;
                }
                else k /= 10;
            }
            while(p != 0){
                if (p % 10 == 0){
                    flag = true;
                    break;
                }
                else p /= 10;
            }
            if (!flag){
                ans[0] = i;
                ans[1] = n-i;
                break;
            }
        }
        return ans;

    }

    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (c % 2 == 0)
                ans += (a % 2 == 0 ? 0 : 1) + (b % 2 == 0 ? 0 : 1);
            else
                ans += (a % 2 == 1 ? 0 : 1) * (b % 2 == 1 ? 0 : 1);

            a >>= 1;
            b >>= 1;
            c >>= 1;

        }
        return ans;
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        int ans = n - 1;
        int []b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = i;
        }
        for (int i = 0; i < connections.length; i++) {
            if (b[connections[i][0]] != b[connections[i][1]]){
                int first = b[connections[i][0]];
                for (int j = 0; j < n; j++) {
                    if (b[j] == first)
                        b[j] = b[connections[i][1]];
                }
                ans -= 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solutionm1d12 m1d12 = new Solutionm1d12();
        int [][]con1 = new int[][]{{0,1},{0,2},{1,2}};
        int [][]con2 = new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}};
        System.out.println(m1d12.makeConnected(4,con1));
        System.out.println(m1d12.makeConnected(8,con2));

    }
}
