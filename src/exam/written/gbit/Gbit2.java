package exam.written.gbit;

import java.util.Scanner;

/**
 * @author liusandao
 * @description Gbit2
 *              给定一个由‘0’~‘9’组成的字符串s(1<=长度<=15)以及数字M(1<=M<=50)
 *              求，由s排列成的数字组合，能够整除M的有多少种
 *
 *              例子：
 *              输入：123 6
 *              输出：2
 *
 *              解释：
 *              s="123"
 *              M = 6;
 *              总共可能的情况有123 132 213 231 321 312
 *              能整除的有 132 312两种
 * @date 2020-4-1 19:46
 */
public class Gbit2 {
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int M;
        M = Integer.valueOf(s.substring(s.indexOf(' ') + 1));
        s = s.substring(0,s.indexOf(' '));
        char[] ch = s.toCharArray();
        int len = s.length();
        boolean first = false;

        if (M % 3 == 0){
            int sum = 0;
            for (int i = 0; i < ch.length; i++) {
                sum += Integer.valueOf(ch[i]);
            }
            if (sum % 3 != 0){
                first = true;
                System.out.println(0);
            }
        }

        StringBuilder sb = new StringBuilder("");

        if (!first) {
            f(sb, ch, len, M);
            System.out.println(ans);
        }

    }

    public static void f(StringBuilder sb, char[] ch, int len, int M){
        if (sb.length() == len){
            if (Long.valueOf(sb.toString()) % (long)M == 0){
                ans++;
            }
        }
        for (int i = 0; i < len; i++) {
            if (ch[i] == '-'){
                continue;
            }
            else {
                if (M % 2 == 0 && sb.length() == 0 && Integer.valueOf(ch[i]) % 2 == 1){
                    continue;
                }
                sb.insert(0,ch[i]);
                ch[i] = '-';
                f(sb, ch, len, M);
                ch[i] = sb.charAt(0);
                sb.deleteCharAt(0);
            }
        }
    }


}
