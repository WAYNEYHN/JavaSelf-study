# 泛型(Generics)

### 1、为什么需要泛型

- 没有泛型，Collection不知道存入的数据是什么类型的，仅仅知道是Object。因此在get的时候返回的是Object。**在获取该对象后还需要强制转换**
- Collection、Map集合对于元素的类型没有限制。本来一个Collection集合中存放的都是同一个类的对象，但别人放入另一个对象也是没有任何语法错误的。

### 2、泛型的好处

- 代码更加简洁【不用强制转化】
- 程序更加健壮【只要编译时期没有警告，那么运行时期就不会出现ClassCastExecption异常】
- 可读性和稳定性【在编写集合的时候，就限定了类型】
- 有了泛型后使用增强for遍历集合

### 3、泛型的使用

#### 3.1泛型类

**泛型类就是把泛型定义在类上，用户使用该类的时候，才把类型明确下来**....这样的话，用户明确了什么类型，该类就代表着什么类型...用户在使用的时候就不用担心强转的问题，运行时转换异常的问题了

- 泛型类的定义

```java
package pratice.demo.collectionTest;
public class Generics<T>{
    private T unknowType;
    Generics(T unknowType){
        setUnknowType(unknowType);
    }
    public T getUnknowType() {
        return unknowType;
    }
    public void setUnknowType(T unknowType) {
        this.unknowType = unknowType;
    }
}

```

如果在定义泛型类对象的时候泛型信息缺失并让一个未缺失泛型信息的同类泛型类的引用之前这个对象，编译器会给出一个unchecked Exception。在对象的使用过程中会由于泛型信息导致类型的问题。

一个非泛型的引用指向一个泛型的对象编译器也会给出一个unchecked Exception，

泛型类的泛型信息默认extend Object，也可以自己指定父类，这样就可以调用父类中的信息	

3.2泛型方法

- 定义泛型方法：泛型是先定义后使用的

  ```java
  public <T> void show(T t) {        						System.out.println(t);
  }
  ```

  用户传进来的是啥返回的就是啥

#### 3.3泛型类的子类

- 子类明确泛型类的类型参数变量

  ```java
  public interface Inter<T> {
      public abstract void show(T t);
  
  }
  /**
   * 子类明确泛型类的类型参数变量:
   */
  
  public class InterImpl implements Inter<String> {
      @Override
      public void show(String s) {
          System.out.println(s);
  
      }
  }
  ```

  

- 子类不明确泛型类的类型参数变量

  当子类不明确泛型类的类型参数变量是，外界使用子类的时候，也需要传递类型参数变量进来，在实现类上需要定义出类型参数变量

  ```java
  public class InterImpl<T> implements Inter<T> {
  
      @Override
      public void show(T t) {
          System.out.println(t);
  
      }
  }
  
      public static void main(String[] args) {
          //测试第一种情况
          //Inter<String> i = new InterImpl();
          //i.show("hello");
  
          //第二种情况测试
          Inter<String> ii = new InterImpl<>();
          ii.show("100");
  
      }
  ```

  

