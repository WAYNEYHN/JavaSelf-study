package pratice.demo.List;

public class DoubleLinkedNode extends Node {
    private DoubleLinkedNode preNode;
    private DoubleLinkedNode nextNode;
    public DoubleLinkedNode(Object nodeValue){
        super(nodeValue);
        this.preNode = null;
    }


    public void setNextNode(DoubleLinkedNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public DoubleLinkedNode getNextNode() {
        return nextNode;
    }

    public DoubleLinkedNode getPreNode(){
        return this.preNode;
    }

    public void setPreNode(DoubleLinkedNode preNode) {
        this.preNode = preNode;
    }

    public boolean PreNodeIsEmpty(){
        if(this.preNode == null){
            return true;
        }
        return false;
    }
}
