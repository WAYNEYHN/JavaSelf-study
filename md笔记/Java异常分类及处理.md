# [Java异常分类及处理](https://www.cnblogs.com/niceyoo/p/10585459.html)

#### 一、概念

如果某个方法不能按照正常的途径完成任务，就可以通过另一种路径退出方法。在这种情况下
会抛出一个封装了错误信息的对象。此时，这个方法会立刻退出同时不返回任何值。另外，调用
这个方法的其他代码也无法继续执行，异常处理机制会将代码执行交给异常处理器。

#### 二、异常分类

Throwable 是 Java 语言中所有错误或异常的超类，在 Java 中只有 Throwable 类型的实例才可以被抛出（throw）或者捕获（catch），它是异常处理机制的基本组成类型。
实例分为 Error 和 Exception 两种。

### 2.1、Error

Error（错误）是系统中的错误，程序员是不能改变的和处理的，是在程序编译时出现的错误，只能通过修改程序才能修正。一般是指与虚拟机相关的问题，如系统崩溃，虚拟机错误，内存空间不足，方法调用栈溢等。对于这类错误的导致的应用程序中断，仅靠程序本身无法恢复和和预防，遇到这样的错误，建议让程序终止。

### 2.2、Exception

Exception（异常）表示程序可以处理的异常，可以捕获且可能恢复。遇到这类异常，应该尽可能处理异常，使程序恢复运行，而不应该随意终止异常。

Exception 又有两个分支 ， 一个是运行时异常 RuntimeException ， 一 个是检查异常 CheckedException。

RuntimeException 如 ：NullPointerException 、 ClassCastException ；
CheckedException 如： I/O 错误导致的 IOException、SQLException。

RuntimeException 是那些可能在 Java 虚拟机正常运行期间抛出的异常的超类。 如果出现 RuntimeException，那么一
定是程序员代码书写导致的错误.

CheckedException：一般是外部错误，这种异常都发生在编译阶段，Java 编译器会强
制程序去捕获此类异常，即会出现要求你把这段可能出现异常的程序进行 try catch，该类异常一
般包括几个方面：

1. 试图在文件尾部读取数据
2. 试图打开一个错误格式的 URL
3. 试图根据给定的字符串查找 class 对象，而这个字符串表示的类并不存在

throws：在方法的声明上使用，表示此方法在调用时必须处理异常。

##### 检查型异常（Checked Exception）与非检查型异常（Unchecked Exception）区别？

所有的检查性异常都继承自java.lang.Exception；所有的非检查性异常都继承自java.lang.RuntimeException。
检查性异常和非检查性异常最主要的区别在于其处理异常的方式：检查性异常必须使用try catch或者throws等关键字进行处理，否则编译器会报错;非检查性异常一般是程序代码写的不够严谨而导致的问题，可以通过修改代码来规避。
常见的运行时异常：空指针异常(NullPointerException)、除零异常(ArithmeticException)、数组越界异常(ArrayIndexOutOfBoundsException)等;
常见的检查性异常：输入输出异常(IOException)、文件不存在异常(FileNotFoundException)、SQL语句异常(SQLException)等。



#### 三、异常的处理方式

### 3.1、不处理

遇到异常问题不进行具体处理，而是继续抛给调用者 （throw，throws）
抛出异常有三种形式，一是 throw，再就是 throws，还有一种系统自动抛异常。

```java
public static void main(String[] args) {
    String s = "abc";
    if(s.equals("abc")) {
        // 手动抛出一个数字格式化异常
        throw new NumberFormatException();
    } else {
        System.out.println(s);
    }
}

int div(int a,int b) throws Exception{
    return a/b;
}
```

### 3.2、处理

try catch 捕获异常针对性处理方式

1、异常的处理方案

```java
try...catch、try...catch...finally、try...finally
    try{
        可能会发生的异常
    }catch(异常类型 异常名(变量)){
        针对异常进行处理的代码
    }catch(异常类型 异常名(变量)){
        针对异常进行处理的代码
    }...
    [finally{
        释放资源代码；
    }]
```

注意：

catch 不能独立于 try 存在。
catch里面不能没有内容
在 try/catch 后面添加 finally 块并非强制性要求的。
try 代码后不能既没 catch 块也没 finally 块。
try里面越少越好。
try, catch, finally 块之间不能添加任何代码。
finally里面的代码最终一定会执行（除了JVM退出）
如果程序可能存在多个异常，需要多个catch进行捕获。
异常如果是同级关系，catch谁前谁后没有关系
如果异常之间存在上下级关系，上级需要放在后面

#### 四、Throw 和 throws 的区别

throws 用在函数上，后面跟的是异常类，可以跟多个；

> 语法：[(修饰符)](https://www.cnblogs.com/niceyoo/p/返回值类型)(方法名)([参数列表])[throws(异常类)]{……}
> public void doA(int a) throws Exception1,Exception3{……}

throw 用在函数内，后面跟的是异常对象。

throws E1,E2,E3只是告诉程序这个方法可能会抛出这些异常，方法的调用者可能要处理这些异常，而这些异常E1，E2，E3可能是该函数体产生的。
throw则是明确了这个地方要抛出这个异常。

结合来看：

```java
void doA(int a) throws IOException,{
   try{
      ......
   }catch(Exception1 e){
      throw e;
   }catch(Exception2 e){
      System.out.println("出错了！");
   }
   if(a!=b)
      throw new  Exception3("自定义异常");
}
```

throws 用来声明异常，让调用者知道该功能可能会出现的问题（比如上方的 IO 异常），可以给出预先的处理方式；
throw 抛出具体的问题对象，执行到 throw，功能就已经结束了，跳转到调用者，并将具体的问题对象抛给调用者。
也就是说 throw 语句独立存在时，下面不要定义其他语句，因为执行不到。

> 概括:
> throws 表示出现异常的一种可能性，并不一定会发生这些异常；
> throw 则是抛出了异常，执行 throw 则一定抛出了某种异常对象。

#### 五、自定义异常

在 Java 中你可以自定义异常。如果要自定义异常类，则扩展Exception类即可，因此这样的自定义异常都属于检查异常（checked exception）。如果要自定义非检查异常，则扩展自RuntimeException。

按照国际惯例，自定义的异常应该总是包含如下的构造函数：

一个无参构造函数
一个带有String参数的构造函数，并传递给父类的构造函数。
一个带有String参数和Throwable参数，并都传递给父类构造函数
一个带有Throwable 参数的构造函数，并传递给父类的构造函数。
下面是IOException类的完整源代码，可以借鉴。

package java.io;

public class IOException extends Exception {
    static final long serialVersionUID = 7818375828146090155L;

    public IOException() {
    super();
    }
     
    public IOException(String message) {
    super(message);
    }
     
    public IOException(String message, Throwable cause) {
        super(message, cause);
    }
     
    public IOException(Throwable cause) {
        super(cause);
    }
}
finally块和return

首先一个不容易理解的事实：

- 在 try块中即便有return，break，continue等改变执行流的语句，finally也会执行。
- finally中的return 会覆盖 try 或者catch中的返回值。
- finally中的return或异常会抑制（消灭）前面try或者catch块中的异常。

#### 六、几个问题





### 6.1在catch捕获异常时，为什么不考虑使用Throwable类型，而只是使用Exception来进行接收？

Throwable表示的范围要比Exception大。实际上程序使用Throwable来进行处理，没有任何语法问题，但是却会存在逻辑问题。因为此时出现的（或者说用户能够处理的）只有Exception类型，而如果使用Throwable接收，还会表示可以处理Error的错误，而用户是处理不了Error错误的，所以在开发中用户可以处理的异常都要求以Exception类为主。

### 6.2异常是一起处理好还是分开处理好？

根据实际的开发要求是否严格来决定。在实际的项目开发项目工作中，所有的异常是统一使用Exception处理还是分开处理，完全根据开发者的项目开发标准来决定。如果项目开发环境严谨，基本上要求针对每一种异常分别进行处理，并且要详细记录下异常产生的时间以及产生的位置，这样可以方便程序维护人员进行代码的维护。再次注意：处理多个异常时，捕获范围小的异常要放在捕获范围大的异常之前处理。


