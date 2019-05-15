# 协程

类似于线程，执行异步操作，却又是在主线程中，不会阻塞线程。

- launch 启动协程

- delay 延迟(相当于Thread.sleep)

- runBlocking 为防止概念混淆，统统没有线程的概念，但需要模拟线程的阻塞效果，可用于包装main()方法

- suspend关键字 只有被"suspend"修饰的挂起函数才能在携程中执行

- repeat 重复i次

- join ？？？

- cancel 取消协程的执行

- cancelAndJoin 取消协程的执行并等待协程内原有的代码执行完毕

