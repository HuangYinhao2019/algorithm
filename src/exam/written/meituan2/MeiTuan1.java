package exam.written.meituan2;

import java.util.Scanner;

/**
 * @author liusandao
 * @description MeiTuan1
 * @date 2020-4-9 18:49
 */
public class MeiTuan1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W;
        String s;
        int N;
        W = sc.nextInt();
        s = sc.next();
        N = sc.nextInt();

        int hour = Integer.valueOf(s.substring(0,2));
        int minute = Integer.valueOf(s.substring(3));

        boolean day1 = false;

        int minuteb = N % 60;
        int hourb = N / 60;

        if (minute < minuteb){
            hourb += 1;
            minute = minute + 60 - minuteb;
        }
        else {
            minute = minute - minuteb;
        }

        int dayb = (hourb / 24) % 7;
        hourb %= 24;

        if (hour < hourb){
            dayb++;
            hour = hour + 24 - hourb;
        }
        else {
            hour -= hourb;
        }

        dayb %= 7;

        int w = (W + 6 - dayb) % 7 + 1;

        System.out.println(w);
        String now = new String("");
        if (hour < 10){
            now = now.concat("0".concat(String.valueOf(hour)));
        }
        else {
            now = now.concat(String.valueOf(hour));
        }
        now = now.concat(":");
        if (minute < 10){
            now = now.concat("0".concat(String.valueOf(minute)));
        }
        else {
            now = now.concat(String.valueOf(minute));
        }

        System.out.println(now);

    }

}
