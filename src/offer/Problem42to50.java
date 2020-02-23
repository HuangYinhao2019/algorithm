package offer;

import java.util.*;

public class Problem42to50 {

    public int maxSubArray(int[] nums) {
        int max=nums[0],sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(max < sum)
                max = sum;
            if(sum < 0)
                sum = 0;
        }
        return max;
    }

    public int countDigitOne(int n) {
        //求每个位的数字所用
        int index = 1;
        //记录1的个数
        int count = 0;
        int high = n,cur = 0,low = 0;
        //由于high = n /(index*10) 中index *10 很容易越位
        //特修改如下
        while(high > 0){
            high /= 10;
            cur = (n / index) % 10;
            low = n - (n / index) * index;
            //以下是计算的公式
            if(cur == 0) count += high * index;
            if(cur == 1) count += high * index + low + 1;
            if(cur > 1) count += (high+1) * index;
            index *= 10;
        }
        return count;
    }

    public int findNthDigit(int n) {
        if (n < 10)
            return n;
        long[] a = new long[12];
        a[0] = 1;
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i-1] + (long)Math.pow(10,i-1)* 9L * (long)i;
        }
        int k = 0; //位数
        for (int i = 1; i < a.length; i++) {
            if (a[i] >= n && n > a[i - 1]){
                k = i;
                break;
            }
        }
        long s =  n - a[k-1];
        return String.valueOf((int)Math.pow(10,k-1) + (s / k)).charAt((int)s % k) - '0';

    }

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        return String.join("", list);
    }

    public int translateNum(int num) {
        String s = String.valueOf(num);
        if (s.length() == 1) return 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        dp[1] = Integer.valueOf(s.substring(0,2)) <= 25 ? 2 : 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            if (s.charAt(i-1) != '0' && Integer.valueOf(s.substring(i-1,i+1)) <= 25)
                dp[i] += dp[i-2];
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        Problem42to50 p = new Problem42to50();
        System.out.println(p.findNthDigit(1000000000));
    }

}
