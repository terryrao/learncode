/**
 * nio的核心
 * channel:Channel 有点象流。 数据可以从Channel读到Buffer中，也可以从Buffer 写到Channel中
 * buffer
 * selector
 *
 *
 * channel 类似于流，但有以下不同
 * 1。既可以从中写数据，也可以从中读数据
 * 2。通道可以异步地读写
 * 3。通道的数据总是从buffer中写或者读到buffer
 *
 * 重要实现
 * FileChannel -> 从文件中读写数据
 * DatagramChannel -> 从udp网络中读写数据
 * SocketChannel -> 从tcp网络中读写数据
 * ServerSocketChannel -> 监听新进来的TCP连接，像Web服务器那样。对每一个新进来的连接都会创建一个SocketChannel
 *
 *
 * buffer
 * 实质上是一块可读写的内存块，被包装成 NIO Buffer 对象
 * （一）操作步骤：
 * 1。写入数据到 buffer
 * 2.调用 flip 方法 ()
 * 3。从 buffer 中读取数据
 * 4.调用 clear()方法或者 compact 方法
 *
 * flip 从读模式切换到写模式 读完之后要清除数据 clear 或者 compact
 * clear 清空缓冲区 ; compact 清除已读数据，将未读数据移到当前位置、清的数据放在后面
 *
 * （二）capacity position limit
 *  capacity : Buffer的大小
 *  position ：
 *      (1)写时:表示当前位置，初始值为0，写入数据后，position 会指向下一个可插入数据的 Buffer单元。position 最大为 capacity -1
 *      (2)读时:从 position 位置开始读，当 Buffer 从写模式切换到读模式时，position 会被置为0；当从 Buffer 读取数据时，position 向前移到
 *      下一个可读的位置
 *  limit :
 *      (1)写时:最多能往Buffer中写多少数据等于 capacity
 *      (2)读时:最多能读多少数据。当 Buffer 切换到读模式时，limit 就会被置成写模式下的 position 值。因此能读到之前写的所有值
 *
 *
 *
 *  Selector
 *  Selector 能检测到多个 NIO 通道，并能知道通道是否为读写等事件做好做准备的组件。这样一个单独的线程可以管理多个 Channel，从而管理多个网络连接。
 *  与 Selector 一起使用时，Channel 必须处在非阻塞模式下，而FileChannel不能工作在非阻塞模式中，因而不能混用
 *
 *
 * @author admin
 */
package org.raowei.test.testnio;