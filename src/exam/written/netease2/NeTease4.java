package exam.written.netease2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author liusandao
 * @description Netease4
 *              现在有N个盒子，每个盒子有长宽高(L,W,H)。一个小盒子可以放进一个大盒子里
 *              必须长宽高都小于大盒子，一个大盒子只能放一个小盒子。
 *              现在给你N个盒子，问最多可以把几个打包到一起
 *
 *              输入：[[5,4,3], [5,4,5], [6,6,6]]
 *              输出：2
 *
 *              输入：[[5,6,3], [5,4,6], [6,6,6]]
 *              输出：1
 *
 * @date 2020-4-11 18:57
 */
public class NeTease4 {

    class Box{
        
        int L;
        int W;
        int N;
        List<Box> subboxes;

        public Box(int l, int w, int n) {
            L = l;
            W = w;
            N = n;
            this.subboxes = new ArrayList<>();
        }
    }

    public int maxBoxes (int[][] boxes) {
        Box[] b = new Box[boxes.length];
        Set<Box> root = new HashSet<>();
        for (int i = 0; i < boxes.length; i++) {
            b[i] = new Box(boxes[i][0],boxes[i][1],boxes[i][2]);
            root.add(b[i]);
        }

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[i].L > b[j].L && b[i].W > b[j].W && b[i].N > b[j].N){
                    b[i].subboxes.add(b[j]);
                    root.remove(b[j]);
                }
            }
        }

        int max = -1;
        for (Box box : root) {
            max = Math.max(deep(box), max);
        }
        return max;
    }

    private int deep(Box root){
        if (root.subboxes.size() == 0){
            return 1;
        }
        else {
            int max = -1;
            for (int i = 0; i < root.subboxes.size(); i++) {
                max = Math.max(max,deep(root.subboxes.get(i)));
            }
            return max + 1;
        }
    }

}
