import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeepCopyTest {
    static class Person implements Cloneable,Serializable{
        int a;
        Age age;
        public Person(int a){this.a = a;}
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    static class Age implements Serializable{
        int age;
        public Age(int _age){
            age = _age;
        }
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);

        List<T> copy_list = (List<T>) in.readObject();
        return copy_list;
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        List<Person> l = new ArrayList<Person>();
        Person p = new Person(1);
        Age a = new Age(18);
        p.age = a;
        l.add(p);
//        List<Person> l2 = deepCopy(l);
//        l2.get(0).age.age = 19;
//        System.out.println(l.get(0).age.age);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        l2.addAll(l1);
        List<Person> l3 = new ArrayList<>();
        List<Person> l4 = new ArrayList<>();
        for (Person person:l3)
            l4.add((Person)person.clone());

    }

}
