import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>(15);
        for (int i = 0; i < 30; i++) {
            list.add(i);
        }

        for (Integer i : list) {
            System.out.print(i+"\n");
       }
        Collections.addAll(list, 1, 2, 3, 4);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+"\n");
        }

        MyArrayList<Integer> newlist=new MyArrayList<>(list.size());
        Collections.copy(list,newlist);

//        MyArrayList<Integer> sortedlist=null;
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        System.out.println(Arrays.toString(list.toArray()));
//                sort(List<T> list, Comparator<? super T> c)

    }
}
