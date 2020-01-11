package jian;
import java.lang.StringBuffer;

public class Stringproblem {
    public String replaceSpace(StringBuffer str) {
        int n = 0;
        int oldlength = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') n += 2;
        }
        str.setLength(str.length() + n);
        for (int i = oldlength - 1; i >= 0 ; i--) {
            if (str.charAt(i) != ' ') str.setCharAt(i+n,str.charAt(i));
            else{
                str.setCharAt(i+n,'0');
                str.setCharAt(i+n-1,'2');
                str.setCharAt(i+n-2,'%');
                n -= 2;
            }
        }
        String Ans = new String(str);
        return Ans;
    }

    public static void main(String[] args){
        Stringproblem s = new Stringproblem();
        String a = " We are  happy ";
        StringBuffer str = new StringBuffer(a);

        System.out.println(s.replaceSpace(str));
    }
}
