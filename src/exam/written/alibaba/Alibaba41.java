package exam.written.alibaba;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description Alibaba41
 *              给定一个只包含'0'和'1'的字符串，你可以对字符串任意一位进行翻转操作，
 *              例如选择下标为index的位置翻转，则index,index-1,index+1，三个位置，如果
 *              原来是‘0’则变为‘1’,如果原来是'1'则变为‘0’。如果选择第一位(最后一位)
 *              ，则只翻转该位和右边(左边)。问将整个字符串翻转成全是'0'的最少次数，如果无论
 *              怎样翻转均不可能，则输出No
 *
 *              给定一个T，表示有T行
 *              每一行一个字符串s，1<=长度<=20
 *              每一行输出一个结果，代表最小翻转次数
 * @date 2020-4-1 15:51
 */
public class Alibaba41 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();
        int[] ans = new int[N];
        Arrays.fill(ans,Integer.MAX_VALUE);
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            int len = str.length();
            char[] resc = new char[len];
            Arrays.fill(resc,'0');
            String res = String.valueOf(resc);
            int times = (int)Math.pow(2,len);
            for (int j = 0; j < times; j++) {
                StringBuffer ss = new StringBuffer(str);
                int q = 0;
                int k = j;
                for (int p = 0; p < len; p++) {
                    if (k % 2 == 0){
                        ss = turn(ss,p);
                        q++;
                    }
                    k /= 2;
                }
                if (ss.toString().equals(res)){
                    ans[i] = Math.min(ans[i],q);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                System.out.println("No");
            } else {
                System.out.println(ans[i]);
            }
        }
    }

    public static StringBuffer turn(StringBuffer sb, int index){
        if (index - 1 >= 0){
            if (sb.charAt(index - 1) == '1'){
                sb.setCharAt(index - 1,'0');
            }
            else {
                sb.setCharAt(index - 1, '1');
            }
        }
        if (sb.charAt(index) == '1'){
            sb.setCharAt(index,'0');
        }
        else {
            sb.setCharAt(index,'1');
        }
        if (index + 1 < sb.length()){
            if (sb.charAt(index + 1) == '1'){
                sb.setCharAt(index + 1,'0');
            }
            else {
                sb.setCharAt(index + 1, '1');
            }
        }
        return sb;
    }

}
