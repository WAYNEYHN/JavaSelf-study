package com.algorithm.QafterClass;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

    private int N = 0;
    private Node firstNode = null;

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class Node{
        private Item item;
        private Node nextNode;
    }

    public void push(Item a){

        Node node = new Node();
        node.item = a;
        node.nextNode = firstNode;
        firstNode = node;
//        Node node = firstNode;
//        firstNode = new Node();
//        firstNode.nextNode = node;
//        firstNode.item = a;
        N++;
    }


    public void deleteLast(){
        if(firstNode.nextNode == null){
            firstNode = null;
        }
        Node temp = firstNode;
        Node temp_1 = firstNode;
        while(temp.nextNode != null){
            temp_1 = temp;
            temp = temp.nextNode;
        }
        temp_1.nextNode = null;
    }
    public int size(){
        return N;
    }

    public boolean isImpty(){
        return N==0;
    }
    public Item pop(){
        Item temp = firstNode.item;
        firstNode = firstNode.nextNode;
        N--;
        return temp;
    }

    private class StackIterator implements Iterator<Item>{

        private Node tempNode = firstNode;
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return tempNode != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Item next() {
            Item temp = tempNode.item;
            tempNode = tempNode.nextNode;
            return temp;
        }
    }
}
