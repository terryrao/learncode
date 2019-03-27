# 第五章 并行模式与算法

## 1. 单例模式
通用模式：

```java

public class Singleton {
    private Singleton() {
       //构造器私有 
    }
    
    private static class SingletonHolder{
        private static Singleton singleton = new Singleton(); 
    }
    
    public Singleton getInstance() {
        return SingletonHolder.singleton;
    }
    
}

```

## 不变性
当对象创建后，其内部状态与数据不再改变，实现不变性要保证以下几点：
1. 不能有任何修改自己身属性的方法
2. 所有的属性必须用 final 标记，且为私有
3. 确保子类不能重载修改他的行为
4. 有一个可以创建完整对象的构造函数

## 生产者消费者模型

## Future

Future 执行的时候立即返回一个值，不阻塞线程，在 get 的时候阻塞线程，直到数据准备好。在数据未准备好之前立即返回，提高系统的响应速度。
对于有数据依赖的线程，效果并不理想

## 并行流水线

## 并行搜索

## 并行排序
奇偶排序

