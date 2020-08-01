package leetcode.weekly.weeklym5d10;/**
 * @description Solutionm5d10
 * @author liusandao
 * @date 2020-5-10 10:27
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-10 10:27
 */

public class Solutionm5d10 {

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        for(int i = 1, j = 0; i <= Math.min(target[target.length-1], n); i++){
            if (target[j] == i){
                ans.add("Push");
                j++;
            } else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }

    public int countTriplets(int[] arr) {
        int[] xor = new int[arr.length];
        int a = 0;
        int b = 0;
        xor[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xor[i] = xor[i-1] ^ arr[i];
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = arr.length - 1; k > i; k--) {
                for (int j = i + 1; j <= k; j++) {
                    if (i == 0){
                        a = xor[j - 1];
                    } else {
                        a = xor[j - 1] ^ xor[i - 1];
                    }
                    b = xor[k] ^ xor[j - 1];
                    if (a == b){
                        count++;
//                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
        return count;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        for (int i = 1; i < hasApple.size(); i++) {
            if (hasApple.get(i)){
                break;
            }
            if (i == hasApple.size() - 1){
                return 0;
            }
        }
        List<List<Integer>> tree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            tree.get(from).add(to);
        }
        return nodeTime(0, tree, hasApple) - 2;
    }

    public int nodeTime(int num, List<List<Integer>> tree, List<Boolean> hasApple){
        if (tree.get(num).size() == 0){
            if (hasApple.get(num)){
                return 2;
            } else {
                return 0;
            }
        } else {
            int sum = 0;
            for (int i = 0; i < tree.get(num).size(); i++) {
                sum += nodeTime(tree.get(num).get(i), tree, hasApple);
            }
            if (sum != 0){
                return sum + 2;
            } else if (sum == 0 && hasApple.get(num)){
                return 2;
            } else {
                return 0;
            }
        }
    }

    public int ways(String[] pizza, int k) {
        int n = pizza.length;
        int m = pizza[0].length();
        int[][][] dp = new int[k][n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                for (int i1 = i; i1 < n; i1++){
                    if (pizza[i1].substring(j).contains("A")){
                        dp[0][i][j] = 1;
                        break;
                    }
                }
            }
        }

        for (int t = 1; t < k; t++) {
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    int sum = 0;
                    //横切
                    boolean hasApple = false;
                    for (int iq = i + 1; iq < n; iq++){
                        if (!hasApple){
                            for (int j1 = j; j1 < m; j1++){
                                if (pizza[iq-1].charAt(j1) == 'A'){
                                    hasApple = true;
                                    break;
                                }
                            }
                        }
                        if (hasApple) {
                            sum = (sum + dp[t-1][iq][j]) % 1000000007;
                        }
                    }
                    //竖切
                    hasApple = false;
                    for (int jq = j + 1; jq < m; jq++){
                        if (!hasApple){
                            for (int i1 = i; i1 < n; i1++){
                                if (pizza[i1].charAt(jq-1) == 'A'){
                                    hasApple = true;
                                    break;
                                }
                            }
                        }
                        if (hasApple) {
                            sum = (sum + dp[t-1][i][jq]) % 1000000007;
                        }
                    }
                    dp[t][i][j] = sum;
                }
            }
        }
        return dp[k-1][0][0];
    }


    public static void main(String[] args) {
        Solutionm5d10 s = new Solutionm5d10();
//        int[] arr = new int[]{2,3,1,6,7};
//        System.out.println(s.countTriplets(arr));
        String[] pizza = new String[]{"A..","AAA","..."};
        System.out.println(s.ways(pizza, 3));
    }

}
