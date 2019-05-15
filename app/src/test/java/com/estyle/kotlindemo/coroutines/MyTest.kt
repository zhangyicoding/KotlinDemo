package com.estyle.kotlindemo.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.consumeEachIndexed
import kotlinx.coroutines.channels.produce
import org.junit.Test
import kotlin.concurrent.thread

/**
 * Created by zhangyi on 2019/3/4.
 */
class MyTest {

    val unblockTime = 3 * 1000L
    val blockTime = 10 * 1000L

    fun printlnWithThread(any: Any?) {
        println("$any -> ${Thread.currentThread().name}")
    }

    @Test
    fun demo1() {
        GlobalScope.launch {
            // 在后台启动一个新的协程并继续
            delay(unblockTime) // 非阻塞的等待 1 秒钟（默认时间单位是毫秒）
            printlnWithThread("World") // 在延迟后打印输出
        }
        printlnWithThread("Hello") // 协程已在等待时主线程还在继续

        // 阻塞主线程 2 秒钟来保证 JVM 存活，使用runBlocking替代sleep
//        Thread.sleep(blockTime)
        runBlocking {
            delay(blockTime)
            printlnWithThread("End")
        }
    }

    @Test
    fun demo2() = runBlocking {
//        val job = GlobalScope.launch {
//            delay(unblockTime)
//            printlnWithThread("World")
//        }
//        printlnWithThread("Hello")
//        job.join()// 等待直到子协程执行结束，join只能在挂起函数中调用

        // 简化
        launch {
            delay(unblockTime)
            printlnWithThread("World")
        }
        printlnWithThread("Hello[ ")
    }

    @Test// 黑人问号？？？输出结果为3。1。2。4
    fun demo3() = runBlocking {
        launch {
            delay(200L)
            printlnWithThread("1")
        }

        coroutineScope { // 创建一个新的协程作用域
            launch {
                delay(500L)
                printlnWithThread("2")
            }

            delay(100L)
            printlnWithThread("3") // 这一行会在内嵌 launch 之前输出
        }

        printlnWithThread("4") // 这一行在内嵌 launch 执行完毕后才输出
    }

    // suspend挂起函数，只能在协程中执行
    private suspend fun doWorld(delay: Long, content: Any?) {
        delay(delay)
        printlnWithThread(content)
    }

    // 生产者-消费者模式（基于通道）
    @Test
    fun demo4() = runBlocking {
        val receiveChannel = produce {
            for (i in 0 until 5) send(i * i)
        }
        receiveChannel.consumeEach {
            printlnWithThread(it)
        }
    }

    // 管道（基于生产者-消费者）
    // 生产无穷数据，做平方处理，打印
    @Test
    fun demo5() = runBlocking {
        // 1、生产无穷数据
        val numbersChannel = produce {
            var x = 0
            while (true) send(x++)
        }
        // 2、平方
        val resultChannel = produce {
            for (i in numbersChannel) {
                send(i * i)
            }
        }
        // 3、打印
        // 4.就打印前10个吧，无穷打印就挂了
        resultChannel.consumeEachIndexed {
            if (it.index < 5) {
                printlnWithThread("${it.index} : ${it.value}")
            } else {
                coroutineContext.cancelChildren()
            }
        }
    }

    // 乒乓球demo
    // 有乒和乓两个协程，还有桌子通道，协程通过通道传输球对象
    suspend fun play(name: String, table: Channel<TableTennis>) {
        table.consumeEachIndexed {
            val ball = it.value
            ball.hits++
            printlnWithThread("order: ${it.index}, $name, hits:   ${ball.hits}")
            delay(500L)
            table.send(ball)
        }
    }
    @Test
    fun demo6() = runBlocking {
        val table = Channel<TableTennis>()
        launch { play("乓", table) }
        launch { play("乒", table) }
        table.send(TableTennis(0))

        delay(blockTime)
        coroutineContext.cancelChildren()
    }
}
