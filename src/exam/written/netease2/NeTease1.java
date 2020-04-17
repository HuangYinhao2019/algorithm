package exam.written.netease2;

/**
 * @author liusandao
 * @description NeTeaSe1
 *              给两个9进制的数，要求加法，求和，保留小数部分尾部的0
 *              "1.28","1.71"
 * @date 2020-4-11 18:57
 */
public class NeTease1 {

    public String add (String num1, String num2) {
        if (num1.charAt(0) != '-' && num2.charAt(0) != '-'){
            return positiveAdd(num1,num2);
        }
        else {
            return "-".concat(positiveAdd(num1.substring(1),num2.substring(1)));
        }

    }

    public String positiveAdd(String num1, String num2){
        String znum1 = "", xnum1 = "";
        String znum2 = "", xnum2 = "";
        boolean has1 = true, has2 = true;
        //xans:小数结果 zans:整数结果
        String xans, zans = "";
        //小数进位
        int ji = 0;

        if (num1.indexOf('.') != -1){
            znum1 = num1.substring(0,num1.indexOf('.'));
            xnum1 = num1.substring(num1.indexOf('.') + 1);
        }
        else {
            znum1 = num1;
            has1 = false;
        }
        if (num2.indexOf('.') != -1){
            znum2 = num2.substring(0,num2.indexOf('.'));
            xnum2 = num2.substring(num2.indexOf('.') + 1);
        }
        else {
            znum2 = num2;
            has2 = false;
        }

        if (has1 && has2){
            int len1 = xnum1.length();
            int len2 = xnum2.length();
            int i = Math.min(len1,len2) - 1;
            String s = new String("");
            for(;i >= 0;i--){
                int t = xnum1.charAt(i) - '0' + xnum2.charAt(i) - '0' + ji;
                ji = t / 9;
                t %= 9;
                s = String.valueOf(t).concat(s);
            }
            if (len1 > len2){
                s.concat(xnum1.substring(len2));
            }
            else {
                s.concat(xnum2.substring(len1));
            }
            xans = s;
        }
        else if (has1 || has2){
            xans = has1 ? xnum1 : xnum2;
        }
        else {
            xans = "-";
        }

        while(znum1.length() != znum2.length()){
            if (znum1.length() < znum2.length()){
                znum1 = "0".concat(znum1);
            }
            else{
                znum2 = "0".concat(znum2);
            }
        }

        for (int j = znum1.length() - 1; j >= 0; j--) {
            int t = znum1.charAt(j) - '0' + znum2.charAt(j) - '0' + ji;
            ji = t / 9;
            t %= 9;
            zans = String.valueOf(t).concat(zans);
        }
        if (ji > 0){
            zans = "1".concat(zans);
        }

        if (xans.equals("-")){
            return zans;
        }
        else {
            return zans.concat(".").concat(xans);
        }
    }

    public static void main(String[] args) {
        NeTease1 Test = new NeTease1();
        System.out.println(Test.add("0000","84.78246513216845872465132"));
    }

}
