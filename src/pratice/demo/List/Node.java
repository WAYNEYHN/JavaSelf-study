package pratice.demo.List;

public class Node {
    private Object nodeValue;
    private Node nextNode;
    public Node(Object nodeValue){
        this.nodeValue = nodeValue;
        this.nextNode = null;
    }
    public Node(){
        this.nodeValue = null;
        this.nextNode = null;
    }
    public Object getNodeValue() {
        return nodeValue;
    }
    public void setNodeValue(Object temp){
        nodeValue = temp;
    }
    public Node getNextNode() {
        return nextNode;
    }
    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    //判断当前节点的下一节点是否为空
    public boolean NextNodeisEmpty(){
        if (this.getNextNode() == null){
            return true;
        }
        return false;
    }
}
