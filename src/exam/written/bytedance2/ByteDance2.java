package exam.written.bytedance2;/**
 * @description ByteDance2
 * @author liusandao
 * @date 2020-5-11 9:50
 */

import java.util.*;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-11 09:50
 */

public class ByteDance2 {

    public static void main(String[] args) {
        final int MOD = 835672545;
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int N = 0;
        N = sc.nextInt();
        sc.nextLine();
        String[] dict = new String[N];
        for (int i = 0; i < N; i++) {
            dict[i] = sc.nextLine();
        }
        List<Set<String>> list = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            list.add(new HashSet<>());
        }
        for (int i = 0; i < N; i++) {
            list.get(dict[i].length() - 1).add(dict[i]);
        }

        int[] dp = new int[text.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 1; j <= list.size(); j++) {
                if (i + 1 - j >= 0) {
                    String sub = text.substring(i + 1 - j, i + 1);
                    if (list.get(j-1).contains(sub)){
                        dp[i+1] = (dp[i+1] + dp[i+1-j]) % MOD;
                    }
                }
            }
        }
        System.out.println(dp[text.length()]);
    }

}
