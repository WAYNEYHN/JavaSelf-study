package wayne.learn.reg2nfa;

public class state {
    public int nStateID; //顶点编号，在整个NFA中定点编号是唯一的
    public Arrow pFirstArrow; //当前顶点的连接的第一条箭弧的指针
    public state(int a,Arrow b) {
        nStateID=a;
        pFirstArrow=b;
    }
    public state() {

    }
}
