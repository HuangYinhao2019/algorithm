package leetcode.daily.daily5;/**
 * @description Day2
 * @author liusandao
 * @date 2020-5-2 8:34
 */

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-02 08:34
 */

public class Day2 {

    public int lengthOfLongestSubstring(String s) {
        //真实面试题：如何用20个字节解决该问题（s中只有小写字母）
        int max = 0;
        int p = 0;
        int q = 0;
        long b = 0;
        long a = 0;
        if(s.length() == 0) {
            return 0;
        }
        while(p < s.length() && q < s.length())
        {
            if (((s.charAt(p) < 63) && (b & (1L << s.charAt(p))) == 0) || (s.charAt(p) >= 63 && (a & (1L << s.charAt(p) - 63)) == 0)){
                if (s.charAt(p) < 63) {
                    b |= 1L << s.charAt(p);
                }
                else {
                    a |= 1L << s.charAt(p) - 63;
                }
                p++;
                max = Math.max(max, p - q);
            }
            else {
                if (s.charAt(p) < 63) {
                    while ((b & (1L << s.charAt(p))) != 0) {
                        b ^= 1L << s.charAt(q);
                        q++;
                    }
                }
                else {
                    while ((a & (1L << s.charAt(p) - 63)) != 0) {
                        a ^= 1L << s.charAt(q) - 63;
                        q++;
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Day2 d = new Day2();
        String s = "hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789hijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        System.out.println(d.lengthOfLongestSubstring(s));
    }

}
