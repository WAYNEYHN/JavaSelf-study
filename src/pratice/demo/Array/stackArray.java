package pratice.demo.Array;

public class stackArray {
    private String[] item;
    private int n;//栈的容量
    private int count;

    public stackArray(int n){
        item = new String[n];
        this.n = n;
        count = 0;
    }

    public boolean push(String temp){
        if(count>=n) return false;
        else{
            item[count] = temp;
            count++;
            return true;
        }
    }

    public String pop(){
        if(count == 0) return null;
        else{
            String tmp = item[count-1];
            count--;
            return tmp;
        }
    }

    public void Show(){
        for(int i = 0; i < count; i++){
            System.out.println("第"+ i + "项:"+ item[i]);
        }
    }


}
