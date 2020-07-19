package wayne.learn.LL_1;
import java.util.Scanner;
//E -> E + T | T
//T -> T * F | F
//F -> ( E ) | i

//E -> T E’
//E’ -> + TE’ |ε
//T -> FT’
//T’ -> * FT’ |ε
//F -> ( E ) | i

public class RecursivePredictiveAnalysis {
    static String InputStr=null;
    static int tag=0;
    static boolean flag=true;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while((InputStr=sc.nextLine())!=null && InputStr.length()!=0){
            ParseE();
            if(InputStr.charAt(tag)!='#' || !flag)
                System.out.println("fail");
            else if(flag)
                System.out.println("success");
            flag=true;
            tag=0;
        }
    }
    static void ParseE(){//E->TE'
        ParseT();
        ParseE1();
    }
    static void ParseE1(){//E'->+TE'|ε
        switch (InputStr.charAt(tag)){
            case '+':
                tag++;ParseT();ParseE1();
                break;
            case '#':
            case ')':
                break;
            default:
                flag=false;
                break;
        }
    }
    static void ParseT(){//T->FT'
        ParseF();
        ParseT1();
    }
    static void ParseT1(){//T'->*FT'|ε
        switch (InputStr.charAt(tag)){
            case '*':
                tag++;ParseF();ParseT1();
                break;
            case '#':
            case  ')':
            case  '+':
                break;
            default:
                flag=false;
                break;
        }
    }
    static void ParseF(){//F->(E)|i
        switch (InputStr.charAt(tag)){
            case 'i':
                tag++;break;
            case  '(':
                tag++;ParseE();
                if(InputStr.charAt(tag)==')')
                    tag++;
                break;
            default:
                flag=false;
                break;
        }
    }

}
