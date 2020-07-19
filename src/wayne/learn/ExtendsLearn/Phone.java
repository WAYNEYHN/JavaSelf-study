package wayne.learn.ExtendsLearn;

public class Phone extends merchandise {
    private String os;
    private String manufacturer;
    Phone(String id, String Name, int count, double Price, String os){
        super(id, Name, count, Price);
        this.os = os;
    }

    public String getOs() {
        return os;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public void Print() {
        super.Print();
        System.out.println("手机名"+ getName());
        System.out.println("操作系统"+ os);
    }
}
