public class Test {
    public static void main(String[] args) {
        T t = new T();
        System.out.println(t.f(3));
        Test test = new Test();
        System.out.println(test.k(3));
    }
    private int k(int j){
        return j;
    }
}

class T {
    public int f(int i) {
        return i;
    }
}