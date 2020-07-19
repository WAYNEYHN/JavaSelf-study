package wayne.learn.reg2nfa;

public class Arrow {
    public int  nEndStateID; //箭弧终点的节点状态ID
    public char  chLetter; //箭弧上标注的字符
    public Arrow  pNextArrow; //与当前边有相同开始接点的下条箭弧
    public Arrow(int a,char b,Arrow c) {
        nEndStateID=a;
        chLetter=b;
        pNextArrow=c;
    }
    public Arrow() {

    }
}
