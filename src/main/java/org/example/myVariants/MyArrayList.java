package org.example.myVariants;

import java.util.Arrays;

public class MyArrayList<T>{
    private static final Object[] emptyArr = {};
    private T[] list;

    private int size;

    private final int capacity;
    private final int default_capacity = 10;

    public MyArrayList(int capacity){
        if (capacity<=0){
            throw new IllegalArgumentException("Capacity <= 0");
        }else {
            list = (T[]) new Object[capacity];
        }
        this.capacity = capacity;
    }

    public MyArrayList(){
        list = (T[]) new Object[default_capacity];
        capacity = default_capacity;
    }

    public boolean add(T item) {
        add(item, list, size);
        trimToSize();
        return true;
    }

    private void add(T e, Object[] list, int s) {
        if (s == list.length)
            list = sizeInc();
        list[s] = e;
        size = s + 1;

    }

    public void add(int index, T item) {
        final int s;
        Object[] list;
        if ((s = size) == (list = this.list).length)
            list = sizeInc();
        System.arraycopy(list, index, list, index + 1, s - index);
        list[index] = item;
        size = s + 1;
        trimToSize();
    }

    private Object[] sizeInc() {
        return sizeInc(size + 1);
    }

    private void trimToSize() {
        if (size < list.length) {
            list = (size == 0)
                    ? (T[]) emptyArr
                    : Arrays.copyOf(list, size);
        }
    }

    private Object[] sizeInc(int minCapacity) {
        int oldCapacity = list.length;
        if (oldCapacity > 0 ) {
            int newCapacity = newLength(oldCapacity,
                    minCapacity - oldCapacity,
                    oldCapacity >> 1           );
            return list = Arrays.copyOf(list, newCapacity);
        } else {
            return list = (T[]) new Object[Math.max(default_capacity, minCapacity)];
        }
    }

    private static int newLength(int oldLength, int minGrowth, int prefGrowth) {
        int prefLength = oldLength + Math.max(minGrowth, prefGrowth);
        if (0 < prefLength && prefLength <= Integer.MAX_VALUE) {
            return prefLength;
        } else{
            return 0;
        }

    }

    public void delete(int index){
        final int newSize=size - 1;
        if (index<0 || index>size){
            throw new IllegalArgumentException("Index out of bounds");
        }
        for (int i=index; i<newSize; i++){
            list[i] = list[i + 1];
        }
        size--;
        trimToSize();
    }

    public void delete(T item){
        int pos = index(item);
        if (pos<0){
            return;
        }
        delete(pos);
    }

    private int index(T item){
        if(item == null){
            return -1;
        }
        for (int i=0; i<size; i++){
            if (item.equals(list[i])){
                return i;
            }
        }
        return -1;
    }

    public T get(int index){
        if (index<0 || index>=size){
            throw new IllegalArgumentException("Index out of bounds");
        }
        return list[index];
    }

    public void set(int index, T item){
        list[index]=item;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(list, size));
    }

    public int getCapacity() {return capacity;}

    public int getSize() {return size;}

    public void arrayInfo (MyArrayList<T> testArrayList){
        System.out.print("Массив: ");
        for (T item: list){
            System.out.print(item+" ");
        }

        System.out.println("\nРазмер: " + testArrayList.getSize() + "\n");
    }
}
