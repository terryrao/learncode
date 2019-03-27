# java8 与并发

@FunctionalInterface

只能有一个抽象方法，并且不能是 Object 类里实现的方法。
```java
    @FunctionalInterface
    interface Func {
        void handle();
        boolean equals();
    }
// 编译器可以通过，equals 是 Object 类的方法
```

CompletableFuture

java 8 中 Future 的改进版

StampedLock

读写锁的改进版， 为读操作提供了乐观策略。



