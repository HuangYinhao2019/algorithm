import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    static public class A implements Cloneable{
        int a;
        public A(int a){
            this.a = a;
        }
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        String str1 = new String("ABC") + "ABC";
        String str2 = "ABC" + "ABC";
    }

}
