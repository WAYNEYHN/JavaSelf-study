package com.algorithm.QafterClass;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{
     private Item[] a;
     private int N = 0;
     //构造函数，创建一个栈数组
     public ResizingArrayStack(int cap){
         a = (Item[]) new Object[cap];
     }

     public void push(Item temp){
         if(N == a.length) resize(a.length*2);
         a[N++] = temp;
     }

     public Item pop(){
         Item temp = a[N--];
         a[N] = null; //方式出现对象游离
         if(N < a.length/4) resize(a.length/2);
         return temp;

     }
     public int size(){
         return N;
     }

     private void resize(int max){
         Item[] temp = (Item[]) new Object[max];
         if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
         a = temp;
     }

     public Iterator<Item> iterator(){
         return new ReverseArrayIterator();
     }

     public class ReverseArrayIterator implements Iterator<Item>{

         private int i = N;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return i>0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            return a[--i];
        }
    }
}
