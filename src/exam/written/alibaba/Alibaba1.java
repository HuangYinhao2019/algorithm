package exam.written.alibaba;

import java.util.*;
import org.junit.Test;

/**
 * @author liusandao
 * @description Alibaba 3-20
 * @date 2020-3-20 10:48
 */
public class Alibaba1 {

    //打牌，双扣
    public int Poker(int[] cards){
    return subPoker(cards,0);
    }

    private int subPoker(int[] cards, int k){
    int ans = Integer.MAX_VALUE;
    if (k >= cards.length) {
        return 0;
    }
    //当前牌出完，出下一张
    else if (cards[k] == 0){
        return subPoker(cards,k+1);
    }
    //出连对
    if (k <= cards.length - 3 && cards[k] >= 2 && cards[k+1] >= 2 && cards[k+2] >=2){
        cards[k] -= 2;
        cards[k+1] -= 2;
        cards[k+2] -= 2;
        ans = Math.min(1+subPoker(cards,k),ans);
        cards[k] += 2;
        cards[k+1] += 2;
        cards[k+2] += 2;
    }
    //出顺子
    if (k <= cards.length - 5 && cards[k] >= 1 && cards[k+1] >= 1 && cards[k+2] >=1 && cards[k+3] >= 1 && cards[k+4] >= 1){
        cards[k] -= 1;
        cards[k+1] -= 1;
        cards[k+2] -= 1;
        cards[k+3] -= 1;
        cards[k+4] -= 1;
        ans = Math.min(1+subPoker(cards,k),ans);
        cards[k] += 1;
        cards[k+1] += 1;
        cards[k+2] += 1;
        cards[k+3] += 1;
        cards[k+4] += 1;
    }
    //出对子
    if (cards[k] >= 2){
        cards[k] -= 2;
        ans = Math.min(1+subPoker(cards,k),ans);
        cards[k] += 2;
    }
    //出单牌
    if (cards[k] >= 1){
        cards[k] -= 1;
        ans = Math.min(1+subPoker(cards,k),ans);
        cards[k] += 1;
    }

    return ans;

    }

    //上升字符串最大连接，返回最大连接长度
    public int maxLengthConcat(String[] str){
    int ans = 0;
    int[] dp = new int[26];
    int[] add = new int[26];
    List<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
    for (int i = 0; i < 26; i++) {
        l.add(new ArrayList<String>());
    }

    //用桶的思想，将以(int)x结尾的字符串装到相应的桶里
    for (int i = 0; i < str.length; i++) {
        //字符结尾
        int j = str[i].charAt(str[i].length()-1) - 'a';
        //特殊情况，以x开头并以x结尾，不装入，将长度加到add数组，可以视为
        //所有以x结尾的字符串的长度，默认+add[x]
        if (str[i].charAt(0) - 'a' == j) {
            add[j] += str[i].length();
        }
        else {
            l.get(j).add(str[i]);
        }
    }

    //初始化以'a'为结尾的最长长度
    for (int i = 0; i < l.get(0).size(); i++) {
        dp[0] = Math.max(l.get(0).get(i).length(),dp[0]);
    }

    //从'a'开始更新
    for (int i = 0; i < 26; i++) {
        //遍历以'a'为结尾的字符串
        if (l.get(i).size() == 0 && add[i] > 0){
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i],dp[j]);
            }
        }
        for (int j = 0; j < l.get(i).size(); j++) {
            //看是否能以与以'a'之前结尾的字符串连接
            String s = l.get(i).get(j);
            int len = s.length();
            int c = s.charAt(0) - 'a';
            for (int k = 0; k <= c; k++) {
                dp[i] = Math.max(dp[i], dp[k] + len);
            }
        }

        dp[i] += add[i];
    }

    for (int i = 0; i < 26; i++) {
        ans = ans > dp[i] ? ans : dp[i];
    }

    return ans;
    }

    @Test
    public void Test1(){
        String[] str = new String[]{"abc","aaa","def","aaaaa","efghijk","ggg","gijklmnopqrst","stuvw"};
        System.out.println(maxLengthConcat(str));
    }

    public static void main(String[] args) {

        long ts = System.currentTimeMillis();


        long te = System.currentTimeMillis();
        System.out.println((te - ts) + "millis");


    }

}
