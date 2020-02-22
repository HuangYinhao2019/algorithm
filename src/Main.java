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
        String s = "B";
        String s1 = s + "C";

    }

}
