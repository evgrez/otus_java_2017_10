package ru.otus.evgrez.task3;


import java.util.*;
import java.util.function.Consumer;

public class MyArrayList<T> implements List<T> {
    private Object[] array;
    private int initMemArray =10;
    private int sizeArray=0;

    public MyArrayList() {
        initArray();
    }

    public MyArrayList(int sizeList) {
        this.initMemArray =sizeList;
        initArray();
    }

    private void initArray(){
        array=new Object[initMemArray];
    }
    public int size() {
        return sizeArray;
    }

    public boolean isEmpty() {
        return (sizeArray!=0);
    }

    public boolean contains(Object o) {
        if (true) throw new RuntimeException();
        return false;
    }

    public Iterator<T> iterator() {

        return new MyIterator();
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, sizeArray);
    }

    public <T1> T1[] toArray(T1[] a) {
        if (true) throw new RuntimeException();
        return null;
    }

    public boolean add(T t) {
        if (sizeArray==array.length){
            allocMemory();
        }
        array[sizeArray]=(Object)t;
        sizeArray++;
        return true;
    }
    private void allocMemory(){
        initMemArray = initMemArray *2;
        Object[] temp = new Object[array.length*2];
        java.lang.System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }
    public boolean remove(Object o) {
        if (true) throw new RuntimeException();
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        if (true) throw new RuntimeException();
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        if (true) throw new RuntimeException();
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        if (true) throw new RuntimeException();
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        if (true) throw new RuntimeException();
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        if (true) throw new RuntimeException();
        return false;
    }

    public void clear() {
        if (true) throw new RuntimeException();
    }

    public T get(int index) {
        if (index>=sizeArray || index<0) throw new IndexOutOfBoundsException();
        return (T)array[index];
    }

    public T set(int index, T element) {
        if (index>=sizeArray || index<0) throw new IndexOutOfBoundsException();
        Object old = array[index];
        array[index]=element;
        return (T)old;
    }

    public void add(int index, T element) {
        if (true) throw new RuntimeException();
    }

    public T remove(int index) {
        if (true) throw new RuntimeException();
        return null;
    }

    public int indexOf(Object o) {
        if (true) throw new RuntimeException();
        return 0;
    }

    public int lastIndexOf(Object o) {
        if (true) throw new RuntimeException();
        return 0;
    }

    public ListIterator<T> listIterator() {
        return new MyIterator();
    }

    public ListIterator<T> listIterator(int index) {
        if (true) throw new RuntimeException();
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        if (true) throw new RuntimeException();
        return null;
    }

    class MyIterator implements Iterator<T>
            , ListIterator<T>
    {
        private int cur=0;

        public boolean hasNext() {
            if (cur+1<sizeArray) return true;
            else return false;
        }

        public T next() {
            if (cur>=sizeArray)
                throw new IndexOutOfBoundsException();
            return (T)array[++cur];
        }

        public void remove() {
            if (true) throw new RuntimeException();
        }

        public void forEachRemaining(Consumer<? super T> action) {
            if (true) throw new RuntimeException();
        }

        @Override
        public boolean hasPrevious() {
            if (true) throw new RuntimeException();
            return false;
        }

        @Override
        public T previous() {
            if (true) throw new RuntimeException();
            return null;
        }

        @Override
        public int nextIndex() {
            if (true) throw new RuntimeException();
            return 0;
        }

        @Override
        public int previousIndex() {
            if (true) throw new RuntimeException();
            return 0;
        }

        @Override
        public void set(T t) {
            MyArrayList.this.set(cur-1, t);
        }

        @Override
        public void add(T t) {
            if (true) throw new RuntimeException();
        }
    }
}