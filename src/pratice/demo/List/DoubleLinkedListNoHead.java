package pratice.demo.List;

public class DoubleLinkedListNoHead {
    DoubleLinkedNode doubleLinkedNode;
    public DoubleLinkedListNoHead(Object nodeValue){
        doubleLinkedNode = new DoubleLinkedNode(nodeValue);
    }

    public void addToTail(DoubleLinkedNode newNode){
        DoubleLinkedNode flagNode = doubleLinkedNode;
        while (!flagNode.NextNodeisEmpty()) {
            flagNode = flagNode.getNextNode();
        }
        newNode.setPreNode(flagNode);
        flagNode.setNextNode(newNode);

    }

    public void addToHead(DoubleLinkedNode newNode){
        DoubleLinkedNode flagNode = doubleLinkedNode;
        while (flagNode.PreNodeIsEmpty()){
           flagNode = flagNode.getPreNode();
        }
        flagNode.setPreNode(newNode);
    }

    public void showDoubleLinkedList(){
        DoubleLinkedNode flagNode = doubleLinkedNode;
        int i = 0;
        while(!flagNode.NextNodeisEmpty()){
            System.out.print("节点"+ i+": ");
            System.out.println(flagNode.getNodeValue());
            flagNode = flagNode.getNextNode();
            i++;
        }
        System.out.print("节点"+ i+": ");
        System.out.println(flagNode.getNodeValue());

    }




}
