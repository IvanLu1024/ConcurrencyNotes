# 并发学习

## 基本概念

* 并发：同时拥有两个或者多个线程，如果程序在单核处理器上运行，多个线程将交替的换入或者换出内存，
这些线程是同时"存在"的，每个线程都处于执行过程中的某个状态，
如果运行在多核处理器上，此时，程序中的每个线程都将分配到一个处理器核上，因此可以同时运行。

* 高并发：是互联网分布式系统架构设计中必须考虑的因素之一，
它通常是指，通过系统设计保证系统能够同时并行处理很多请求。

理解：

并发：多个线程操作相同的资源,保证线程安全，合理使用资源

高并发：服务能同时处理很多请求，提高程序性能

## 学习框架
<div align="center"><img src="pics//concurrency.jpg"></div>

## 仓库目录
### 并发基础
- [并发基础](https://github.com/DuHouAn/ConcurrencyNotes/blob/master/notes/并发基础.md)

### 线程安全性

- [线程安全性](https://github.com/DuHouAn/ConcurrencyNotes/blob/master/notes/%E7%BA%BF%E7%A8%8B%E5%AE%89%E5%85%A8%E6%80%A7.md)

- [线程安全性相关代码](https://github.com/DuHouAn/ConcurrencyNotes/tree/master/src/main/java/code_00_threadSafe/atomic)
