package exam.written.meituan3;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan2
 * @date 2020-4-16 19:00
 */
public class MeiTuan2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,m;
        long x;
        a = sc.nextInt();
        b = sc.nextInt();
        m = sc.nextInt();
        x = sc.nextLong();
        HashMap<Long ,Integer> map = new HashMap<>();
        int index = 0;
        while(true){
            x = ((a * x) + b) % m;
            if (map.containsKey(x)){
                System.out.println(index - map.get(x));
                break;
            }
            else {
                map.put(x,index);
                index++;
            }
        }
    }

}
