package wayne.learn.reg2nfa;
import java.util.ArrayList;
import java.util.Stack;

public class reg2nfa {
    public static void main(String[] args) {
        Stack<state> pStateList=new Stack<state>();    //状态栈
        Stack<Character> operatorStack=new Stack<Character>(); //符号栈
        ArrayList<state> list=new ArrayList<state>();
        String reg="((a.b)*|b*)*";     //a*.b*
        String operator="*.|()#";
        int a[][]= {                         //0:无优先级	 1:<	2:>	3:=
                //优先关系表	 //*	.	|	(	)	#
                {2,2,2,1,2,2},			//*
                {1,1,2,1,2,2},			//.
                {1,1,1,1,2,2},			//|
                {1,1,1,1,3,2},			//(
                {2,2,2,0,2,2},			//)
                {1,1,1,1,0,3}			//#
        };
        int stcnt=0;
        operatorStack.push('#');
        reg=reg+'#';
        state begin=new state(stcnt++,null);
        list.add(begin);
        int index=0,n=reg.length(),arrowcnt=0;
        System.out.println(n);
        char ch=reg.charAt(index);
        System.out.println(reg);
        out:
        while(index<n) {

            if(Character.isDigit(ch)||Character.isLetter(ch)) {
                state beginst=new state(stcnt++,null);  //产生新节点
                state endst=new state(stcnt++,null);

                Arrow line=new Arrow(endst.nStateID,ch,null);  //拉上箭弧
                list.add(beginst);
                list.add(endst);
                arrowcnt++;
                line.pNextArrow=beginst.pFirstArrow;
                beginst.pFirstArrow=line;
                pStateList.push(beginst);
                pStateList.push(endst);
                index++;
                ch=reg.charAt(index);

            }
            else {

                if(a[operator.indexOf(operatorStack.peek())][operator.indexOf(ch)]==3){
                    if(operatorStack.peek()=='('&&ch==')') {
                        operatorStack.pop();
                        index++;
                        ch=reg.charAt(index);
                    }
                    else if(operatorStack.peek()=='#'&&ch=='#') {
                        break out;
                    }
                }


                else if(a[operator.indexOf(operatorStack.peek())][operator.indexOf(ch)]==2) {
                    char tempch=operatorStack.peek();
                    operatorStack.pop();
                    if(tempch=='.') {
                        state beginA,endA,beginB,endB;
                        endA=pStateList.peek();
                        pStateList.pop();
                        beginA=pStateList.peek();
                        pStateList.pop();
                        endB=pStateList.peek();
                        pStateList.pop();
                        beginB=pStateList.peek();
                        pStateList.pop();
                        Arrow t=new Arrow(beginA.nStateID,'?',null);
                        t.pNextArrow=endB.pFirstArrow;
                        endB.pFirstArrow=t;

                        arrowcnt++;
                        pStateList.push(beginB);
                        pStateList.push(endA);
                    }
                    else if(tempch=='|') {
                        state beginA,endA,beginB,endB,beginC,endC;
                        endA=pStateList.peek();
                        pStateList.pop();
                        beginA=pStateList.peek();
                        pStateList.pop();
                        endB=pStateList.peek();
                        pStateList.pop();
                        beginB=pStateList.peek();
                        pStateList.pop();
                        beginC=new state(stcnt++,null);
                        endC=new state(stcnt++,null);

                        Arrow t1=new Arrow(beginA.nStateID,'?',null);
                        Arrow t2=new Arrow(beginB.nStateID,'?',null);
                        Arrow t3=new Arrow(endC.nStateID,'?',null);
                        Arrow t4=new Arrow(endC.nStateID,'?',null);
                        t1.pNextArrow=beginC.pFirstArrow;
                        beginC.pFirstArrow=t1;

                        t2.pNextArrow=beginC.pFirstArrow;
                        beginC.pFirstArrow=t2;

                        t3.pNextArrow=endA.pFirstArrow;
                        endA.pFirstArrow=t3;

                        t4.pNextArrow=endB.pFirstArrow;
                        endB.pFirstArrow=t4;

                        list.add(beginC);
                        list.add(endC);
                        arrowcnt+=4;
                        pStateList.push(beginC);
                        pStateList.push(endC);

                    }
                    else if(tempch=='*') {
                        state beginA,endA,beginC,endC;
                        endA=pStateList.peek();
                        pStateList.pop();
                        beginA=pStateList.peek();
                        pStateList.pop();
                        beginC=new state(stcnt++,null);
                        endC=new state(stcnt++,null);

                        Arrow t1=new Arrow(beginA.nStateID,'?',null);
                        Arrow t2=new Arrow(endC.nStateID,'?',null);
                        Arrow t3=new Arrow(beginA.nStateID,'?',null);
                        Arrow t4=new Arrow(endC.nStateID,'?',null);
                        t1.pNextArrow=beginC.pFirstArrow;
                        beginC.pFirstArrow=t1;

                        t2.pNextArrow=endA.pFirstArrow;
                        endA.pFirstArrow=t2;

                        t3.pNextArrow=endA.pFirstArrow;
                        endA.pFirstArrow=t3;

                        t4.pNextArrow=beginC.pFirstArrow;
                        beginC.pFirstArrow=t4;

                        list.add(beginC);
                        list.add(endC);
                        arrowcnt+=4;
                        pStateList.push(beginC);
                        pStateList.push(endC);
                    }
                }
                else if(a[operator.indexOf(operatorStack.peek())][operator.indexOf(ch)]==1) {
                    operatorStack.push(ch);
                    index++;
                    ch=reg.charAt(index);
                }

            }


        }
        //开始结点与状态栈中的结点连接
        state beginA,endA;
        Arrow temp;
        endA=pStateList.peek();
        pStateList.pop();
        beginA=pStateList.peek();
        pStateList.pop();
        Arrow t=new Arrow(beginA.nStateID,'?',null);
        begin.pFirstArrow=t;
        arrowcnt++;

        System.out.println("stcnt="+stcnt);
        System.out.println("arrowcnt="+arrowcnt);
        for(int i=0;i<stcnt;i++) {
            System.out.print(i);
            temp=list.get(i).pFirstArrow;
            while(temp!=null) {
                System.out.print("[-"+temp.chLetter+"->"+temp.nEndStateID+"]");
                temp=temp.pNextArrow;
            }
            System.out.println();
        }



    }
}
