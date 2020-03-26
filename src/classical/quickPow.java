package classical;

/**
 * @author liusandao
 * @description quickPow
 * @date 2020-3-23 20:25
 */
public class quickPow {

    public static int qPow(int n, int p){

        int res = 1;
        while (p != 0){
            if (p % 2 == 1){
                res *= n;
            }
            n *= n;
            p /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(qPow(2,20));
        System.out.println(Math.pow(2, 20));
    }

}
