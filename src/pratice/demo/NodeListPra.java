package pratice.demo;
import pratice.demo.List.*;

public class NodeListPra{
    public static void main(String[] args) {
          //具有头结点的链表
        SingleLinkedListWithHead singleLinkedList = new SingleLinkedListWithHead();
        singleLinkedList.addToTail(new Node(10));
        singleLinkedList.addToTail(new Node(11));
        singleLinkedList.addToTail(new Node(12));
        singleLinkedList.addToTail(new Node(13));
        System.out.println("带头节点的链表：");
        singleLinkedList.showLinkedList();
        singleLinkedList.deleteNode(12);
        System.out.println();
        singleLinkedList.showLinkedList();
        System.out.println();
        singleLinkedList.ListInversion(singleLinkedList.getHead(), singleLinkedList.getHead().getNextNode());
        singleLinkedList.showLinkedList();
        //没有头节点, 实现一个简单的LRU
//        int flag = 10;
//        System.out.println("没有头节点的链表：");
//        SingleLinkedListNoHead singleLinkedListNoHead = new SingleLinkedListNoHead();
//        singleLinkedListNoHead.addToHead(new Node(11));
//        singleLinkedListNoHead.addToHead(new Node(12));
//        singleLinkedListNoHead.addToHead(new Node(13));
//        singleLinkedListNoHead.addToHead(new Node(11));
//        singleLinkedListNoHead.addToHead(new Node(12));
//        singleLinkedListNoHead.addToHead(new Node(13));
//        singleLinkedListNoHead.addToHead(new Node(11));
//        singleLinkedListNoHead.addToHead(new Node(12));
//        singleLinkedListNoHead.addToHead(new Node(13));
//        singleLinkedListNoHead.addToHead(new Node(11));
//        singleLinkedListNoHead.addToHead(new Node(12));
//        singleLinkedListNoHead.addToHead(new Node(13));
//
//        singleLinkedListNoHead.showLinkedList();
//        singleLinkedListNoHead.deleteNode(11);
//        System.out.println();
//        singleLinkedListNoHead.addToTail(new Node(16));
//        singleLinkedListNoHead.showLinkedList();

        //双向链表
//        System.out.println("双向链表");
//        DoubleLinkedListNoHead doubleLinkedListNoHead = new DoubleLinkedListNoHead(11);
//        doubleLinkedListNoHead.addToTail(new DoubleLinkedNode(12));
//        doubleLinkedListNoHead.addToTail(new DoubleLinkedNode(13));
//        doubleLinkedListNoHead.addToTail(new DoubleLinkedNode(14));
//        doubleLinkedListNoHead.showDoubleLinkedList();

    }
}
