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
        throw new RuntimeException();
    }

    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public Object[] toArray() {
        return Arrays.copyOf(array, sizeArray);
    }

    public <T1> T1[] toArray(T1[] a) {
        throw new RuntimeException();
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
        throw new RuntimeException();
    }

    public boolean containsAll(Collection<?> c) {
        throw new RuntimeException();
    }

    public boolean addAll(Collection<? extends T> c) {
        throw new RuntimeException();
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        throw new RuntimeException();
    }

    public boolean removeAll(Collection<?> c) {
        throw new RuntimeException();
    }

    public boolean retainAll(Collection<?> c) {
        throw new RuntimeException();
    }

    public void clear() {
        throw new RuntimeException();
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
        throw new RuntimeException();
    }

    public T remove(int index) {
        throw new RuntimeException();
    }

    public int indexOf(Object o) {
        throw new RuntimeException();
    }

    public int lastIndexOf(Object o) {
        throw new RuntimeException();
    }

    public ListIterator<T> listIterator() {
        return new MyIterator();
    }

    public ListIterator<T> listIterator(int index) {
        throw new RuntimeException();
    }

    public List<T> subList(int fromIndex, int toIndex) {
        throw new RuntimeException();
    }

    class MyIterator implements Iterator<T>
            , ListIterator<T>
    {
        private int cur=-1;

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
            throw new RuntimeException();
        }

        public void forEachRemaining(Consumer<? super T> action) {
            throw new RuntimeException();
        }

        @Override
        public boolean hasPrevious() {
            throw new RuntimeException();
        }

        @Override
        public T previous() {
            throw new RuntimeException();
        }

        @Override
        public int nextIndex() {
            throw new RuntimeException();
        }

        @Override
        public int previousIndex() {
            throw new RuntimeException();
        }

        @Override
        public void set(T t) {
            MyArrayList.this.set(cur, t);
        }

        @Override
        public void add(T t) {
            throw new RuntimeException();
        }
    }
}