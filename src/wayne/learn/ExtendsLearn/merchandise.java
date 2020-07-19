package wayne.learn.ExtendsLearn;


import java.util.Objects;

public class merchandise {
    private String id;
    private String Name;
    private int count;
    private double Price;

    merchandise(String id, String Name, int count, double Price){
        this.id = id;
        this.count =count;
        this.Name = Name;
        this.Price = Price;
    }
    public double getPrice() {
        return Price;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }

    public String getName() {
        return Name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void Print(){
        System.out.println("商品id"+ getId());
        System.out.println("数量"+ getCount());
        System.out.println("商品价格"+ getPrice());
    }

    public static void describe(){
        System.out.println("merchandise");
    }
    

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof merchandise)) return false;
        merchandise that = (merchandise) o;
        return getCount() == that.getCount() &&
                Double.compare(that.getPrice(), getPrice()) == 0 &&
                Objects.equals(getId(), that.getId()) &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCount(), getPrice());
    }
}
