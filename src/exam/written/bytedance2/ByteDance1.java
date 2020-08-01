package exam.written.bytedance2;/**
 * @description ByteDance1
 * @author liusandao
 * @date 2020-5-11 9:50
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-11 09:50
 */

public class ByteDance1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        N = sc.nextInt();
        sc.nextLine();
        List<String> record = new ArrayList<String>();
        record.add("");
        for (int i = 0; i < N; i++) {
            String op = sc.nextLine();
            int a = op.charAt(0) - '0';
            if (a == 4){
                if (record.size() >= 1) {
                    record.remove(record.size() - 1);
                }
                continue;
            } else if (a == 1){
                String last = record.get(record.size() - 1);
                record.add(last + op.substring(op.indexOf(' ') + 1));
            } else if (a == 2){
                String last = record.get(record.size() - 1);
                int k = Integer.valueOf(op.substring(op.indexOf(' ') + 1));
                record.add(last.substring(0, last.length() - k));
            } else {
                int k = Integer.valueOf(op.substring(op.indexOf(' ') + 1));
                System.out.println(record.get(record.size() - 1).charAt(k - 1));
            }
        }
    }

}
