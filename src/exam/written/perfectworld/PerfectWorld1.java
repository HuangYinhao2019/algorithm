package exam.written.perfectworld;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description PerfectWorld1
 * @date 2020-4-14 19:38
 */
public class PerfectWorld1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String people = sc.nextLine();
        int carry = sc.nextInt();
        String[] p = people.split(" ");
        int[] weight = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            weight[i] = Integer.valueOf(p[i]);
        }

        Arrays.sort(weight);
        int ans = 0;
        int i = 0, j = weight.length - 1;
        while (i <= j){
            if (weight[i] + weight[j] <= carry){
                i++;
                j--;
                ans++;
            }
            else {
                j--;
                ans++;
            }
        }
        System.out.println(ans);
    }

}
