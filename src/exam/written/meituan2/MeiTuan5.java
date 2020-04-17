package exam.written.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan5
 * @date 2020-4-9 18:49
 */
import java.util.Arrays;
import java.util.Scanner;

public class MeiTuan5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, K;
        N = sc.nextInt();
        K = sc.nextInt();
        String[] s = new String[K];
        boolean[] exists = new boolean[K];
        Arrays.fill(exists,true);
        for (int i = 0; i < K; i++) {
            s[i] = sc.next();
        }
        for (int i = 0; i < N; i++) {
            String operate = sc.next();
            if (operate.startsWith("+")){
                exists[Integer.valueOf(operate.substring(1)) - 1] = true;
            }
            else if (operate.startsWith("-")){
                exists[Integer.valueOf(operate.substring(1)) - 1] = false;
            }
            else {
                int ans = 0;
                for (int j = 0; j < K; j++) {
                    String m = operate.substring(1);
                    if (exists[j] && m.length() >= s[j].length()){
                        int index;
                        while ((index = m.indexOf(s[j])) != -1){
                            ans++;
                            m = m.substring(index + 1);
                        }
                    }
                }
                System.out.println(ans);
            }
        }
    }
}

