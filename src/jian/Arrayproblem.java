package jian;

public class Arrayproblem {

    public void reOrderArray(int [] array) {
        int odd = 0;
        for (int i = 0; i < array.length; i++) 
            if (array[i] % 2 == 1) odd++;
        int []b = array.clone();
        int p = 0;
        for (int i = 0; i < b.length; i++) {
            if (b[i] % 2 == 0) array[odd++] = b[i];
            else array[p++] = b[i];
        }
    }

    public static void main(String[] args) {
        Arrayproblem a = new Arrayproblem();

    }
}
