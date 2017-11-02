/**
 * Created by user on 02.11.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        for (int i = 0; i < 200; i++) {
            list.add(i);
        }

//        for (Integer i : list) {
//            System.out.print(i+"\n");
//        }

        for (int i = 0; i < 200; i++) {
            System.out.print(list.get(i)+"\n");
        }

    }
}
