package pratice.demo.List;

import java.util.Objects;

public class SingleLinkedListWithHead {
    private Node head;

    public SingleLinkedListWithHead(){
        this.head = new Node();
    }

    public Node getHead() {
        return head;
    }

    //尾插法
    public void addToTail(Node e){
        Node flag = head;
        while(flag.getNextNode() != null){
          flag = flag.getNextNode();
        }
        flag.setNextNode(e);
    }

    //根据指定的节点的值删除节点
    public void deleteNode(Object e){
        Node flagNode = head; //被判断节点
        Node PreNode = head; //记录被判断节点的父节点
        while(!flagNode.NextNodeisEmpty()){
            if(flagNode.getNodeValue() == e){
                PreNode.setNextNode(flagNode.getNextNode());
            }
            PreNode = flagNode;
            flagNode = flagNode.getNextNode();
        }
    }

    //遍历并输出所有节点信息
    public void showLinkedList(){
        Node flag = head.getNextNode();
        int i = 0;
        //如果当前节点的指针域不为空，则输出当前节点
        while (!flag.NextNodeisEmpty()){
            System.out.print("节点"+ i+": ");
            System.out.println(flag.getNodeValue());
            flag = flag.getNextNode();
            i++;
        }
        //由于最后一个节点的指针域为空，所以会漏掉一个
        System.out.print("节点" + i+ ": ");
        System.out.println(flag.getNodeValue());
    }

    public void ListInversion(Node CurrentNode, Node ParentNode){
        Node flag = new Node();
        Node tag = new Node();
        flag.setNextNode(CurrentNode.getNextNode());
        tag.setNextNode(ParentNode.getNextNode());
        if(!flag.getNextNode().getNextNode().NextNodeisEmpty()){
            tag.setNextNode(flag.getNextNode());
            flag.setNextNode(flag.getNextNode().getNextNode());
            ListInversion(flag, tag);
            flag.getNextNode().setNextNode(tag.getNextNode());
        }
        else{
            flag.getNextNode().setNextNode(tag.getNextNode());
            return ;
        }

    }


}
