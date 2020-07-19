package pratice.demo.collectionTest;

/**
 * 泛型类的定义
 * @param <T>
 */
public class GenericsClass<T>{
    private T unknowType;

    GenericsClass(T unknowType){
        setUnknowType(unknowType);
    }
    public T getUnknowType() {
        return unknowType;
    }

    public void setUnknowType(T unknowType) {
        this.unknowType = unknowType;
    }
    public void show(){
        System.out.println("woshishui");
    }
}
