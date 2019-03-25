# 要点：

### 1. 计算线程数的经验公式：

        Nt = Nc * Uc * (1 + W/C)
        
Nt : 线程数

Nc : cpu 数量

Uc : 目标 cpu 的使用率  0 <= Uc <= 1

W/C : 等待时间与计算时间之比


### 2. 线程池会异常处理
如果使用异常处理,可以使用 execute 来代替 submit

### 3. 并发容器
1. concurrentHashMap 线程安全的 HashMap
2. CopyOnWriteArrayList 线程安全的 ArrayList 适合读多写少的场景（此时效果好于 vector）
3. ConcurrentLinkedQueue: LinkedList 的线程安全版本
4. BlockingList: 阻塞队列接口，适合于数据共享
5. ConcurrentSkipListMap: 基于跳表的数据结构进行快速查找（适用增加或者减少比较少，但查询较多的场景）

### 4. 共享容器 BlockingQueue
实现类：

| 实现类 | 作用
| --- | --- |
| ArrayBlockingQueue|  底层实现是数组，适合有界队列 |
| DelayedWorkQueue  | 延迟队列|                  |
| DelayQueue        | 延迟队列|
| LinkedBlockingQueue | 底层实现是链表，适合无界队列|
| PriorityBlockingQueue | 优先队列 |
| SynchronizedQueue | 同步队列 | 

`ArrayBlockingQueue` 的`put ` 和`offer`方法都是向头部压入一个元素， `offer()` 方法，如果队列满了就会立即返回 `false`,
`put()` 方法则会等待，只到有空会出现， `poll()` 和 `take()` 方法都是从尾部取一个元素，当队列为空时 `poll` 方法会直接返回 `null`，
`take` 方法则会等待，只有列表有元素。
