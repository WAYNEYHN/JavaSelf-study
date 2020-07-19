package pratice.demo.List;

/**
 * 实现LRU的一个单链表
 */
public class SingleLinkedListNoHead {
    private Node head;
    private int theLengthOfList = 0;
    private static int CATCHFORLIST = 10;//设置链表的缓存大小
    public  SingleLinkedListNoHead(Object nodeValue){
        head = new Node(nodeValue);
    }
    public SingleLinkedListNoHead(){
        head = new Node();
    }
    //链表长度计数自增
    public void AutoIncrementLength(){
        theLengthOfList++;
    }
    //链表长度计数自减
    public void AutoDecrementLength(){
        theLengthOfList--;
    }
    public int getTheLengthOfList() {
        return theLengthOfList;
    }



    /**
     *头插法
     * @param e
     */
    public void addToHead(Node e){
        if(head.getNodeValue() == null){
            head = e;
            AutoIncrementLength();
        }
        else{
            if(getTheLengthOfList()< CATCHFORLIST){
                Node temp = head;
                head = e;
                head.setNextNode(temp);
                AutoIncrementLength();
            }
            else if(getTheLengthOfList()>= CATCHFORLIST){
                deleteTail();
                Node temp = head;
                head = e;
                head.setNextNode(temp);
                AutoIncrementLength();
            }
        }

    }


    /**
     * 尾插法
     * @param e
     */
    public void addToTail(Node e){
        Node flag = head;
        //判断头节点状态，如果为空则将头节点覆盖
        if(head.getNodeValue() == null){
            head = e;
            AutoIncrementLength();
        }
        else{
            while(flag.getNextNode() != null){
                flag = flag.getNextNode();
            }
            flag.setNextNode(e);
            AutoIncrementLength();
        }

    }


    /**
     * 遍历并输出所有节点信息
     */
    public void showLinkedList(){
        Node flag = head;
        System.out.println("链表长度"+getTheLengthOfList());
        int i = 0;
        //如果当前节点的指针域不为空，则输出当前节点
        while (!flag.NextNodeisEmpty()){
            System.out.print("节点"+ i+": ");
            System.out.println(flag.getNodeValue());
            flag = flag.getNextNode();
            i++;
        }
        System.out.print("节点"+ i+": ");
        System.out.println(flag.getNodeValue());
    }


    /**
     * 根据指定的节点的值删除节点
     * @param e
     */
    public void deleteNode(Object e){
        if(head.getNodeValue() == e){
            head = head.getNextNode();
        }
        else{
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

    }

    /**
     * 删除尾节点
     */
    public void deleteTail(){
        Node flag = head;
        Node temp = head;
        while(!flag.NextNodeisEmpty()){
            temp = flag;
            flag = flag.getNextNode();

        }
        temp.setNextNode(null);
        AutoDecrementLength();
    }
}
