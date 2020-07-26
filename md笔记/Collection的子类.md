# Collection的子类	

### Collection的主要方法：

```java
boolean add(Object o) //添加对象到集合
boolean remove(Object o)//删除指定对象
int size()//返回集合大小
boolean contains(Object o)//查找集合中是否有指定的对象
boolean isEmpty()//判断集合是否为空
Iterator iterator()//返回一个迭代器
boolean containsAll(Collection c)//查找集合中是否有集合c中的元素
boolean addAll(Collection c)//将集合c中所有的元素添加给该集合
void clear()//删除集合中所有元素
void removeAll(Collection c)//从集合中删除c集合中也有的元素
void retainAll(Collection c)//从集合中删除集合c中不包含的元素
```

### 一、List：

1. 可以允许重复对象
2. 可以插入多个null元素
3. 是一个有序的容器，输出的顺序就是插入的顺序
4. 常用的实现类有：ArrayList、LinkedList和Vector，ArrayList数组实现，LinkedList链表实现。

```java
void add(int index,Object element)//在指定位置上添加一个对象
boolean addAll(int index,Collection c)//将集合c的元素添加到指定的位置
Object get(int index)//返回List中指定位置的元素
int indexOf(Object o)//返回第一个出现元素o的位置.
Object remove(int index)//删除指定位置的元素
Object set(int index,Object element)//用元素element取代位置index上的元素,返回被取代的元素
void sort()
```



### 二、Set：

1. 不可重复（重复指的是a1.equals(a2)为true）
2. 无序容器，你无法保证每个元素的存储顺序
3. 只允许一个null元素，如果添加多个null会自动过滤
4. 常用的实现类HashSet，LinkedHashset以及TreeSet

### 三、Map

1. Map不是collection的子接口或者实现类，Map是一个接口
2. Map的每个Entry都持有两个对象，也就是一个键一个值，键对象必须唯一
3. Map里可以有多个null值但只能有一个null键
4. 常用的实现类：HashMap、LinkedHashMap、Hashtable和TreeMap

```java
boolean equals(Object o)//比较对象
boolean remove(Object o)//删除一个对象
put(Object key,Object value)//添加key和value
```

### 四、总结：

1. 如果涉及到堆栈，队列（先进后出）等操作，应该考虑用List，对于需要快速插入，删除元素，应该使用LinkedList，如果需要快速随机访问元素，应该使用ArrayList。

2. 如果程序在单线程环境中，或者访问仅仅在一个线程中进行，考虑非同步的类，其效率较高，如果多个线程可能同时操作一个类，应该使用同步的类。

3. 要特别注意对哈希表的操作，*作为key的对象要正确复写equals和hashCode方法*。

4. 尽量返回接口而非实际的类型，如返回List而非ArrayList，这样如果以后需要将ArrayList换成LinkedList时，客户端代码不用改变。这就是针对抽象编程。

5. ArrayList、HashSet/LinkedHashSet、PriorityQueue、LinkedList是线程不安全的，可以使用synchronized关键字，或者类似下面的方法解决:

   ```java
   List list = Collections.synchronizedList(new ArrayList(...));  
   ```

   

### **五、几个面试常见问题：**

 

1. Q:ArrayList和Vector有什么区别？HashMap和HashTable有什么区别？

     A:Vector和HashTable是线程同步的（synchronized）。性能上，ArrayList和HashMap分别比Vector和Hashtable要好。

2. Q:大致讲解java集合的体系结构
     A:List、Set、Map是这个集合体系中最主要的三个接口。
      其中List和Set继承自Collection接口。
      Set不允许元素重复。HashSet和TreeSet是两个主要的实现类。
      List有序且允许元素重复。ArrayList、LinkedList和Vector是三个主要的实现类。
      Map也属于集合系统，但和Collection接口不同。Map是key对value的映射集合，其中key列就是一个集合。key不能重复，但是value可以重复。HashMap、TreeMap和Hashtable是三个主要的实现类。
      SortedSet和SortedMap接口对元素按指定规则排序，SortedMap是对key列进行排序。

3. Q：Comparable和Comparator区别
     A:调用java.util.Collections.sort(List list)方法来进行排序的时候，List内的Object都必须实现了Comparable接口。
       java.util.Collections.sort(List list，Comparator c)，可以临时声明一个Comparator 来实现排序。



### Collection的继承关系

- ### ![image-20200615102430573](https://gitee.com/WAYNEYHN/TyporaPict/raw/master/img/image-20200615102430573.png)



