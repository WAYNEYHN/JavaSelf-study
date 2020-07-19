package pratice.demo.List;

import pratice.demo.*;
public class queueList{
    Node head = new Node();
    Node tail = new Node();
    Node node = new Node();
    public queueList(){
        head.setNextNode(node);
        tail.setNextNode(node);
        node.setNodeValue(null);
    }

    public boolean inqueue(String temp){
        Node tmp = new Node(temp);
        tail.getNextNode().setNodeValue(tmp);
        tail.setNextNode(tmp);
        return true;
    }
    

    public String dequeue(){
        if(head.getNextNode() == tail.getNextNode()) return "队列为空";
        head.setNextNode(head.getNextNode().getNextNode());
        return head.getNextNode().getNodeValue().toString();
    }
    
}