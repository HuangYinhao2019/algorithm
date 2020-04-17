package exam.written.merchantsbank;

import java.util.Scanner;

/**
 * @author liusandao
 * @description MerchantsBank2
 * @date 2020-4-8 19:31
 */
public class MerchantsBank2 {

    public static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        sc.nextLine();
        ans = new int[T];
        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            String s = str.substring(0,str.indexOf(' '));
            boolean nozero = true;
            while(s.length() != 0 && s.charAt(0) == '0'){
                s = s.substring(1);
                nozero = false;
            }
            if (s.length() < str.substring(str.indexOf(' ') + 1) .length()){
                System.out.println(0);
            }
            else {
                int k = Integer.valueOf(str.substring(str.indexOf(' ') + 1));
                dfs(nozero,s,k,0,0,i);
                System.out.println(ans[i]);
            }
        }
    }

    public static void dfs(boolean first, String s, int k, int pre, int now, int t){
        if (s.length() == 0){
            if (pre + now == k){
                ans[t]++;
            }
        }
        else {
            int num = s.charAt(0) - '0';
            //不加运算符
            if (now >= 0) {
                dfs(false, s.substring(1), k, pre, now * 10 + num, t);
            }
            else {
                dfs(false, s.substring(1), k, pre, now * 10 - num, t);
            }
            if (!first) {
                //加加号
                dfs(false,s.substring(1), k, pre + now, num, t);
                //加减号
                dfs(false,s.substring(1), k, pre + now, -num, t);
            }
        }
    }

}
