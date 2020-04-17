package exam.written.kuaishou;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author liusandao
 * @description KuaiShou3
 * @date 2020-4-12 15:49
 */
public class KuaiShou3 {

    public static class Person{

        int index;
        int a;
        int b;
        int div;

        public Person(int index, int a, int b){
            this.index = index;
            this.a = a;
            this.b = b;
            this.div = a - b;
        }

    }

    public int[] WaitInLine (int[] a, int[] b) {
        // write code here
        Person[] p = new Person[a.length];
        for (int i = 0; i < a.length; i++) {
            p[i] = new Person(i + 1, a[i], b[i]);
        }
        Arrays.sort(p, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.div - o1.div;
            }
        });
        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = p[i].index;
        }
        return ans;
    }

}
