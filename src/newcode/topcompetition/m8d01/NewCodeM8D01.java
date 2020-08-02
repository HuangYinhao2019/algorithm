package newcode.topcompetition.m8d01;

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-01 20:50
 */

public class NewCodeM8D01 {

    public int solve (int n, int x, int[] a) {
        List<Integer> less = new ArrayList<>();
        long out_water = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < x) {
                less.add(a[i]);
            } else {
                out_water += a[i] - x;
                count++;
            }
        }
        Collections.sort(less);
        for (int i = less.size() - 1; i >= 0; i--) {
            if (out_water >= x - less.get(i)) {
                count++;
                out_water -= x - less.get(i);
            } else {
                break;
            }
        }
        return count;
    }

    public String Encode (String key, String str) {
        key = key.replaceAll("j", "i");
        str = str.replaceAll("j", "i");
        String abc = "abcdefghiklmnopqrstuvwxyz";
        Map<Character, Integer> secret = new HashMap<>();
        Map<Integer, Character> s2 = new HashMap<>();
        for (int i = 0; i < key.length(); i++) {
            if (!secret.containsKey(key.charAt(i))) {
                secret.put(key.charAt(i), secret.size());
                s2.put(s2.size(), key.charAt(i));
            }
        }
        for (int i = 0; i < abc.length(); i++) {
            if (!secret.containsKey(abc.charAt(i))) {
                secret.put(abc.charAt(i), secret.size());
                s2.put(s2.size(), abc.charAt(i));
            }
        }
        String ans = new String("");
        for (int i = 0; i < str.length(); i += 2) {
            if (i == str.length() - 1) {
                ans += str.charAt(str.length() - 1);
            } else {
                char a = str.charAt(i);
                char b = str.charAt(i + 1);
                int ac = secret.get(a) / 5;
                int ar = secret.get(a) % 5;
                int bc = secret.get(b) / 5;
                int br = secret.get(b) % 5;
                if (a == b) {
                    ans += a;
                    ans += b;
                } else if (ac == bc) {
                    ar = (ar + 1) % 5;
                    br = (br + 1) % 5;
                    char ca = s2.get(ar + ac * 5);
                    char cb = s2.get(br + bc * 5);
                    ans += ca;
                    ans += cb;
                } else if (ar == br) {
                    ac = (ac + 1) % 5;
                    bc = (bc + 1) % 5;
                    char ca = s2.get(ar + ac * 5);
                    char cb = s2.get(br + bc * 5);
                    ans += ca;
                    ans += cb;
                } else {
                    char ca = s2.get(br + ac * 5);
                    char cb = s2.get(ar + bc * 5);
                    ans += ca;
                    ans += cb;
                }
            }
        }
        return ans;
    }

    public int[] MinimumTimes (int[] arr) {
        int MOD = 3 * 7 * 11;
        int[] dp = new int[MOD];
        Arrays.fill(dp, 100000);
        dp[0] = 0;
        for (int i = 11; i < dp.length; i += 11) {
            dp[i] = dp[i - 11] + 1;
        }
        for (int i = 7; i < dp.length; i += 7) {
            dp[i] = Math.min(dp[i], dp[i - 7] + 1);
            if (i + 7 < dp.length) {
                dp[i] = Math.min(dp[i], dp[i + 7] + 1);
            }
        }
        for (int i = 3; i < dp.length; i += 3) {
            dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            if (i + 3 < dp.length) {
                dp[i] = Math.min(dp[i], dp[i + 3] + 1);
            }
        }
        for (int j = 0; j < dp.length; j++) {
            for (int i = 1; i < dp.length; i++) {
                if (i - 3 >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + 1);
                }
                if (i - 7 >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - 7] + 1);
                }
                if (i - 11 >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - 11] + 1);
                }
                if (i + 3 < dp.length) {
                    dp[i] = Math.min(dp[i], dp[i + 3] + 1);
                }
                if (i + 7 < dp.length) {
                    dp[i] = Math.min(dp[i], dp[i + 7] + 1);
                }
                if (i + 11 < dp.length) {
                    dp[i] = Math.min(dp[i], dp[i + 11] + 1);
                }
            }
        }

        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] += 21 * (arr[i] / MOD);
            res[i] += dp[arr[i] % MOD];
        }
        return res;
    }

    public static void main(String[] args) {
        NewCodeM8D01 n = new NewCodeM8D01();
//        int[] test = new int[]{1,2,3,4,5};
//        System.out.println(n.solve(5, 4, test));
        System.out.println(n.MinimumTimes(new int[]{1,4,14}));
    }

}
