package com.estyle.kotlindemo

import com.estyle.kotlindemo.democlass.PersonEntity
import org.junit.Test

/**
 * 第二个test文件
 */
class MyTest {

    // 内联函数，优点在于直接调用内联函数，而不是创建匿名对象
    inline fun inlineFunction(action1: () -> Unit) {
        println("start")
        action1()
        println("end")
    }
    @Test
    fun inlineTest() {
        inlineFunction {
            if (true) {
                return@inlineFunction
            }
            println("middle")
        }
    }
}