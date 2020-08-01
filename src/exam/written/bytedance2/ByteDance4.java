package exam.written.bytedance2;/**
 * @description ByteDance4
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

public class ByteDance4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        List<TreeSet<Integer>> list = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            list.add(new TreeSet<>());
        }
        for (int i = 0; i < s.length(); i++) {
            list.get(s.charAt(i) - 'a').add(i + 1);
        }
        int N = 0;
        N = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            String[] sp = str.split(" ");
            if (Integer.valueOf(sp[0]) == 2){
                int l = Integer.valueOf(sp[1]);
                int r = Integer.valueOf(sp[2]);
                int sum = 0;
                for (int j = 0; j < 26; j++) {
                    int k1 = hasNumber(list.get(j), l);
                    if (k1 == -1 || (k1 <= r && k1 != -2)){
                        sum++;
                        continue;
                    }
                }
                System.out.println(sum);
            } else {
                int pos = Integer.valueOf(sp[1]);
                char ch = sp[2].charAt(0);
                char b = charArray[pos - 1];
                charArray[pos - 1] = ch;
                list.get(b - 'a').remove(Integer.valueOf(pos));
                list.get(ch - 'a').add(pos);
            }
        }
    }

    public static int hasNumber(TreeSet<Integer> set, int f){
        if (set.size() == 0){
            return -2;
        } else if (set.contains(f)){
            return -1;
        } else {
            Integer in = set.ceiling(f);
            if (in == null){
                return -2;
            }
            return in;
        }
    }

}
