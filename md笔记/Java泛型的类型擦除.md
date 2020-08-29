# Java泛型的类型擦除

Java泛型这个特性是从JDK 1.5才开始加入的，因此为了兼容之前的版本，Java泛型的实现采取了“伪泛型”的策略，即Java在语法上支持泛型，但是在编译阶段会进行所谓的“类型擦除”（Type Erasure），将所有的泛型表示（尖括号中的内容）都替换为具体的类型（其对应的原生态类型），就像完全没有泛型一样。理解类型擦除对于用好泛型是很有帮助的，尤其是一些看起来“疑难杂症”的问题，弄明白了类型擦除也就迎刃而解了。

泛型的类型擦除原则是：

- 消除类型参数声明，即删除<>及其包围的部分。
- 根据类型参数的上下界推断并替换所有的类型参数为原生态类型：如果类型参数是无限制通配符或没有上下界限定则替换为Object，如果存在上下界限定则根据子类替换原则取类型参数的最左边限定类型（即父类）。
- 为了保证类型安全，必要时插入强制类型转换代码。
- 自动产生“桥接方法”以保证擦除类型后的代码仍然具有泛型的“多态性”。

## 1 擦除类定义中的类型参数

### 1.1 无限制类型擦除

当类定义中的类型参数没有任何限制时，在类型擦除中直接被替换为Object，即形如<T>和<?>的类型参数都被替换为Object，参见[1](http://softlab.sdut.edu.cn/blog/subaochen/2017/01/generics-type-erasure/#fig____________)。

![image: http://softlab.sdut.edu.cn/blog/subaochen/wp-content/uploads/sites/4/2017/01/0_home_subaochen_git_blog_imgs_java_type-erasure-class-2.png](http://softlab.sdut.edu.cn/blog/subaochen/wp-content/uploads/sites/4/2017/01/0_home_subaochen_git_blog_imgs_java_type-erasure-class-2.png)



图 1: 擦除类定义中的类型参数

### 1.2 有限制类型擦除



当类定义中的类型参数存在限制（上下界）时，在类型擦除中替换为类型参数的上界或者下界，比如形如<T extends Number>和<? extends Number>的类型参数被替换为Number，<? super Number>被替换为Object，参见[2](http://softlab.sdut.edu.cn/blog/subaochen/2017/01/generics-type-erasure/#fig_______________)。

![image: http://softlab.sdut.edu.cn/blog/subaochen/wp-content/uploads/sites/4/2017/01/1_home_subaochen_git_blog_imgs_java_type-erasure-class-bounded-2.png](http://softlab.sdut.edu.cn/blog/subaochen/wp-content/uploads/sites/4/2017/01/1_home_subaochen_git_blog_imgs_java_type-erasure-class-bounded-2.png)



图 2: 擦除类定义中的有限制类型参数

## 2 擦除方法定义中的类型参数

擦除方法定义中的类型参数原则和擦除类定义中的类型参数是一样的，这里仅以擦除方法定义中的有限制类型参数为例，见[3](http://softlab.sdut.edu.cn/blog/subaochen/2017/01/generics-type-erasure/#fig_____________)。

![image: http://softlab.sdut.edu.cn/blog/subaochen/wp-content/uploads/sites/4/2017/01/2_home_subaochen_git_blog_imgs_java_type-erasure-method-2.png](http://softlab.sdut.edu.cn/blog/subaochen/wp-content/uploads/sites/4/2017/01/2_home_subaochen_git_blog_imgs_java_type-erasure-method-2.png)



图 3: 擦除泛型方法中的类型参数

## 3 桥接方法和泛型的多态

考虑下面的代码：

```java
public interface Info{
    // just return var:-) 
    T info(T var); 
}
public class BridgeMethodTest implements Info {
    @Override
    public Integer info(Integer var) {
        return var;
    }
}
```

按照我们之前类型擦除的经验，在擦除类型后的代码应该是这个样子的：

```java
public interface Info {
    // just return var
    Object info(Object var);
}

public class BridgeMethodTest implements Info {
    @Override
    public Integer info(Integer var) {
        return var;
    }
}
```

但是，明显可以看出，这样擦除类型后的代码在语法上是错误的：`BridgeMethodTest`类中虽然存在一个info方法，但是和Info接口要求覆盖的info方法不一致：参数类型不一致。在这种情况下，Java编译器会自动增加一个所谓的“桥接方法”（bridge method）来满足Java语法的要求，同时也保证了基于泛型的多态能够有效。我们反编译一下`BridgeMethodTest.class`文件可以看到Java编译器到底是如何做的：

```
$ javap BridgeMethodTest.class

Compiled from “BridgeMethodTest.java”

public class BridgeMethodTest implements Info<java.lang.Integer> {

​	public BridgeMethodTest();

​	public java.lang.Integer info(java.lang.Integer);

​	public java.lang.Object info(java.lang.Object);

}
```



可以看出，Java编译器在`BridgeMethodTest`中自动增加了两个方法：默认构造方法和参数为Object的info方法，参数为Object的info方法就是“桥接方法”。如何理解“桥接”二字呢？我们进一步反编译`BridgeMethodTes`t看一下：

```javas
public interface Info {
    // just return var
    Object info(Object var);
}

public class BridgeMethodTest implements Info {
    @Override
    public Integer info(Integer var) {
        return var;
    }
}
```

info(Object)方法通过调用子类的info(Integer)方法搭起了父类和子类的桥梁，也就是说，info(Object obj)这个方法起到了连接父类和子类的作用，使得Java的多态在泛型情况下依然有效。



当然，我们在使用基于泛型的多态时不必过多的考虑“桥接方法”，Java编译器会帮我们打理好一切。



关于桥接方法的更多信息可以参考：[JLS](https://docs.oracle.com/javase/specs/)的相关章节。

## 参考资料



- 

- 

- http://docs.oracle.com/javase/tutorial/java/generics/index.html
- http://docs.oracle.com/javase/tutorial/extra/generics/index.html