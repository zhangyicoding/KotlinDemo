package com.estyle.kotlindemo

import android.util.Log

/**
 * object修饰的类是单例。对应Java的严格表达为：MyLog.INSTANCE.e()
 * 对应Java严格的静态方法要使用@JvmStatic：MyLog.e()
 * 而@JvmStatic注解必须在单例object或伴生对象companion object中使用
 * 参考MySingleton类
 */
object MyLog {// 单例。MyLog.INSTANCE

    @JvmStatic// 使用该注解成为严格意义上的静态方法。MyLog.e(xxx)
    fun e(obj: Any?) = e("", obj)

    @JvmStatic// 如果设置默认值，则不需要上面的重载方法。这种使用方式：MyLog.e(obj = xxx)
    // 如果默认值在后面可以直接省略，就像使用方法重载一样简单
    fun e(tag: String = "", obj: Any?) = Log.e("kt", "${tag} -> ${obj}")

}




//不过如果最后一个 lambda 表达式参数从括号外传给函数函数调用，那么允许默认参数不传值：
//
//fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) { /* …… */ }
//
//foo(1) { println("hello") } // 使用默认值 baz = 1
//foo { println("hello") }    // 使用两个默认值 bar = 0 与 baz = 1