## [NIO](http://note.moguit.cn/#/README?id=nio)

```
## 概念
```

```
Java NIO（New IO），No Blocking IO 非阻塞IO，是从Java1.4版本开始引入的一个新的IO API，可以替代标准的Java IO API。NIO与原来的IO有同样的作用和目的，但是使用的方式完全不同，NIO支持面向缓冲区的，基于通道的IO操作。NIO将以更加高效的方式进行文件读写操作
```

```
NIO是双向的
  - 里面的缓存区是可以双向传输的
```

```
- NIO里面引入的通道的概念
  - 通道可以理解为我们生活中的铁路，它是用于源地址和目的地址连接的
  - 如果需要实际传输的话，那么需要依赖里面的缓冲区
  - 通道负责连接，缓冲区负责传输
```

```
## 通道和缓冲区

Java NIO系统的核心在于：通道（Channel）和缓冲区（Buffer）。通道表示打开到IO设备（例如：文件、套接字）的连接。若需要使用NIO系统，需要获取用于连接IO设备的通道以及用于容纳数据的缓冲区。然后操作缓冲区，对数据进行处理

简而言之：Channel负责传输，Buffer负责存储
```

```
## 缓冲区 Buffer

在Java NIO中负责数据的存取。缓冲区就是数组。用于存储不同类型的数据根据数据类型不同，提供相同类型的缓冲区（除了Boolean）

- ByteBuffer：字节缓冲区（最常用的）
- CharBuffer
- ShortBuffer
- IntBuffer
- LongBuffer
- FloatBuffer
- DoubleBuffer
```