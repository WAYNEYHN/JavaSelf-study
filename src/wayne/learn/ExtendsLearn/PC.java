package wayne.learn.ExtendsLearn;

public class PC extends merchandise{
    private String os;
    PC(String id, String Name, int count, double Price, String os){
        super(id, Name, count, Price);
        this.os = os;
    }

    @Override
    public void Print() {
        super.Print();
        System.out.println("电脑名"+ getName());
        System.out.println("操作系统"+ os);
    }

    public static final void describe(){
        System.out.println("PC");
    }
}
