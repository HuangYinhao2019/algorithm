package exam.written.meituan4;

import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-08-29 15:56
 */

public class MeiTuan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        boolean m = false, t = false;
        int begin = 0, end = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'T' && m) {
                begin = i;
                break;
            } else if (str.charAt(i) == 'M') {
                m = true;
            }
        }

        for (int j = str.length() - 1; j >= 0; j--) {
            if (str.charAt(j) == 'M' && t) {
                end = j;
                break;
            } else if (str.charAt(j) == 'T') {
                t = true;
            }
        }
        System.out.println(str.substring(begin + 1, end));
    }

}
