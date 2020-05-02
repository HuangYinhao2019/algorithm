package leetcode.special.leetcode2020spring.personal;/**
 * @description T1
 * @author liusandao
 * @date 2020-4-18 14:57
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-04-18 14:57
 */

public class T1 {
    public int minCount(int[] coins) {
        int sum = 0;
        for(int i = 0; i < coins.length; i++){
            sum += (coins[i] + 1) / 2;
        }
        return sum;
    }

}
