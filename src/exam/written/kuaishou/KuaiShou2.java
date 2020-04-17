package exam.written.kuaishou;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liusandao
 * @description KuaiShou2
 * @date 2020-4-12 15:49
 */
public class KuaiShou2 {

    public int[] GetPowerFactor (int R, int N) {
        // write code here
        if (N == 0 || N == 1 || R == 0){
            if (R == 1){
                return new int[]{0};
            }
            else {
                return new int[0];
            }
        }
        else {
            List<Integer> list = new ArrayList<>();
            int M = 1;
            while (M <= R){
                list.add(M);
                M *= N;
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = list.size() - 1; i >= 0; i--) {
                if (R >= list.get(i)){
                    ans.add(i);
                    R -= list.get(i);
                }
            }
            if (R > 0){
                return new int[0];
            }
            else {
                int[] res = new int[ans.size()];
                for (int i = 0; i < ans.size(); i++) {
                    res[ans.size()-1-i] = ans.get(i);
                }
                return res;
            }
        }
    }

    public static void main(String[] args) {
        int[] show = (new KuaiShou2().GetPowerFactor(50,7));
        for (int i = 0; i < show.length; i++) {
            System.out.println(show[i]);
        }
    }

}
