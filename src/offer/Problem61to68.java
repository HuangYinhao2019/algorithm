package offer;

import java.util.Arrays;

public class Problem61to68 {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int max = -1, min = 14;
        int zero = 0;
        while (nums[zero] == 0)
            zero++;
        for (int i = zero; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                return false;
        }
        if (nums[nums.length-1] - nums[zero] >= 4 - zero && nums[nums.length-1] - nums[zero] < 5)
            return true;
        return false;
    }

    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < prices.length; i++) {
            low = low < prices[i] ? low : prices[i];
            max = max > prices[i] - low ? max : prices[i] - low;
        }
        return max;
    }

    public int sumNums(int n) {
        int k = n;
        boolean b = n > 0 && (k += sumNums(n-1)) > 0;
        return k;
    }

    public int lastRemaining(int n, int m) {
        int flag = 0;
        for (int i = 2; i <= n; i++) {
            flag = (flag + m) % i;
            //动态规划的思想，将f(n,m)替换成flag存储
        }
        return flag;
    }

}
