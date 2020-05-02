package leetcode.special.leetcode2020spring.personal;/**
 * @description T4
 * @author liusandao
 * @date 2020-4-18 14:58
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-18 14:58
 */

public class T4 {

    public int minJump(int[] jump) {
        int[] dp = new int[jump.length];
        for(int i = jump.length - 1; i >= 0; i--){
            if (i+jump[i] >= jump.length){
                dp[i] = 1;
            }
            else {
                dp[i] = dp[i+jump[i]] + 1;
            }
        }
        int[] min = new int[jump.length];
        min[0] = dp[0];
        for (int i = 1; i < jump.length; i++) {
            min[i] = Math.min(min[i-1],dp[i]);
        }
        for (int i = jump.length - 1; i >= 0; i--) {
            if (i+jump[i] >= jump.length){
                dp[i] = 1;
            }
            else {
                dp[i] = Math.min(Math.min(dp[i],min[i] + 1),dp[i+jump[i]] + 1);
                int k = i + 1;
                while (k < jump.length && dp[k] > dp[i]){
                    dp[k] = dp[i] + 1;
                    k++;
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
        if (jump[0] >= jump.length){
            return 1;
        }
        else {
            return dp[0];
        }
    }

    public static void main(String[] args) {
        int[] jump = new int[]{2, 6, 1, 1, 1, 1, 4, 1, 1, 1};
//        int[] copy = Arrays.copyOf(jump, jump.length);
//        System.out.println(Arrays.equals(jump, copy));
//        System.out.println(copy == jump);
//        System.out.println(jump.equals(new int[]{2, 6, 1, 1, 1, 1, 4, 1, 1, 1}));
        System.out.println(new T4().minJump(jump));
    }

}
