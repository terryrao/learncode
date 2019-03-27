# 第三章 锁的优化及注意事项

## 优化锁：

1. 减少锁的持有时间
    
2. 减小锁的粒度

例如 `ConcurrentHashMap` 就将 HashMap 分为若干个 segment 这样就可以提高并行效率。

3. 用读写分离替换独占锁

4. 锁分离

5. 锁的粗化，针对于某些场景中频繁获取、释放锁，特别是在循环中。

## JVM 锁优化
1. 偏向锁
2. 轻量级锁
3. 自旋锁
4. 锁消除 JIT 自己做的优化

## ThreadLocal
ThreadLocal 底层是使用 ThreadLocalMap 的类似 Map 的实现类，存放数据的类是 WeakReference。
ThreadLocal 的变量随着线程结束就会被 jvm 回收。但是现在许多框架都是采用的线程池实现的，因此，
要注意手动释放资源。

为每一个线程分配一个独立的对象对系统性能也许是有帮助的。当然了，这也不一定，这完全取决于共享对象的内部逻辑。
如果共享对象对于竞争的处理容易引起性能损失，我们还是应该考虑使用ThreadLocal为每个线程分配单独的对象。

多线程下产生随机数 ： ThreadLocalDemo2

## 无锁

有锁是一种悲观策略，无锁 CAS（compare and swap）是乐观策略。

CAS 的优势 ：

1. 不会产生死锁
2. 没有锁竞争带来的系统开销
3. 对其它线程影响小

CAS 不足：
ABA 问题

## UnSafe 

应用程序不能使用，原因在下面的代码上：
```java
public static Unsafe getUnsafe() {
    Class cc = Reflection.getCallerClass();
    if (cc.getClassLoader() != null)
        throw new SecurityException("Unsafe");
    return theUnsafe;
}

```
所有的应用程序类都是 AppLoader加载器加载的，而 rt.jar 是由 Bootstrap 加载器加载的，这个类是没有 java 对象的对象（？？）


AtomicReference 、 AtomicStampReference 、 AtomicIntegerArray 、 AtomicIntegerFieldUpdater 

AtomicReference 安全的修改对象的引用

AtomicStampReference 带时间戳的修改引用

AtomicIntegerArray 安全的修改数组

AtomicIntegerFieldUpdater、AtomicLongFieldUpdater、AtomicReferenceFieldUpdater 普通对象的属性修改

注意事项：

1. Updater 是使用反射来获取变量值的，因此要修改的属性不能是 `private`
2. 为了确保变量被正确地读取，该属性必须是 `volatile` 的
3. 由于 CAS 操作是对对象实例中的偏移量直接赋值，因此不支持 `static` 属性修改

SynchronizedQueue

当容器为0时，会阻塞 take 或者 poll 操作，当容器不为空时，会阻塞 put 或者 offer 操作

使用 Jps 和 Jstack 命令可以查看是否有死锁j

