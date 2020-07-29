package com.algorithm.QafterClass;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {

    private Node firstNode;
    private Node lastNode;
    private int N = 0;


    @Override
    public Iterator<Item> iterator() {
        return new queueIterator();
    }

    private class Node{
        Item item;
        Node nextNode;
    }

    public void enqueue(Item a){
        Node tempNode = lastNode;
        Node node = new Node();
        node.item = a;
        node.nextNode= null;
        lastNode = node;
        if(isEmpty()) firstNode = lastNode;
        else tempNode.nextNode = node;
        N++;


    }

    public Item dequeue(){
        Item temp = firstNode.item;
        firstNode = firstNode.nextNode;
        N--;
        return temp;
    }

    public boolean isEmpty(){
        return N==0;
    }

    public class queueIterator implements Iterator<Item>{

        //用来遍历
        private Node flag = firstNode;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return flag != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            Item temp = flag.item;
            flag = flag.nextNode;
            return temp;
        }
    }

}
