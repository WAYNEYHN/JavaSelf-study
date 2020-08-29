package pratice.demo.ThreadTest;

public class climbThread implements Runnable {

    private String name;
    private int time;
    private int num;

    public climbThread(String name, int time, int num){
        this.name = name;
        this.time = time;
        this.num = num;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public void run() {
        for(int i=1; i< this.num; i++){
            try {
                Thread.currentThread().sleep(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"已爬完" + i + "个100米" +
                    "还剩" +(this.num-i)*100 + "米");
            if(i == this.num){
                System.out.println(Thread.currentThread().getName()+"已到达终点");
            }
        }
    }
}
