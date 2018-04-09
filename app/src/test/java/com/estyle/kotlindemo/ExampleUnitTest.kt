package com.estyle.kotlindemo

import org.junit.Test
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun mainTest() {

    }

    // 变量
    var a1 = 1
    var a2: Int = 2
    // 常量
    val a3 = 3

    fun booleanTest() {
        var b1 = true
        var b2 = false
        println(b1 and b2)
        println(b1 or b2)
        println("not true: ${b1.not()}, not false: ${b2.not()}")// false, true
    }

    // 选择表达式，对比三目运算符 ？ ：
    // ==用来比较值。===用来比较对象（可以理解为地址）
    fun maxText(a: Int, b: Int) = if (a > b) a else b

    // 判断类型以及自动强转
    fun isTest(obj: Any): Int? {
        if (obj is String) {// 自动转为String
            return obj.length
        }
        // 离开类型判断，恢复Any类型
        return null
    }

    // 循环

    // for遍历item
    fun forTest() {
        val list = listOf<String>("AAA", "bbb", "ccc")
        for (str in list) {
            println(str)
        }
    }

    // foreach。it：系统自带的、单个参数的隐式名称，代表参数
    fun for2() {
        val list = listOf<String>("AAA", "bbb", "ccc")
        list.forEach { println(it) }// 等效于下面Java8的高端写法

//        list.forEach(System.out::println)// 也等效于下面传统Java的low爆写法

//        for (it : list) {
//            System.out.println(it)
//        }
    }

    // for遍历index
    fun for31Test() {
        val list = listOf<String>("AAA", "bbb", "ccc")
        for (index in list.indices) {
            println("第{$index}个数据是${list[index]}")
        }
    }

    fun for32Test() {
        val list = listOf<String>("AAA", "bbb", "ccc")
        for ((index, value) in list.withIndex()) {
            println("索引值：${index}, 值：${value}")
        }
    }

    // for (int i = 0; i < 10; i+=2) {}
    fun for41Test() {
        for (i in 0..9 step 2) {// [0,9]
            println(i)
        }
    }

    fun for42Test() {
        for (i in 0 until 10) {// [0, 10)
            println(i)
        }
    }

    // for (int i = 5; i > 0; i--) {}
    fun for5Test() {
        for (i in 5 downTo 1) {
            println(i)
        }
    }

    // while遍历
    fun whileTest() {
        val list = listOf<String>("AAA", "bbb", "ccc")
        var index = 0
        while (index < list.size) {
            println("第{$index++}个数据是${list[index]}")
        }
    }

    // when，对比switch
    fun whenTest(obj: Any?) {
        var list = listOf<Int>(-1, -2, -3, -4, -5)
        when (obj) {
            1, 2 -> println("是数字1或2")// 相当于Java中连续两个case对应一个break
            "a" -> println("是字母a")
            is Double -> println("是小数")
            null -> println("为空")
            in 4..6 -> println("在4-6之间")
            in list -> println("在list中")
            getChar('e') -> println("条件可以是表达式，不一定只是常量")
            else -> println("不确定")
        }
    }

    // 可以用任意表达式作为when的条件，而不只是常量
    fun getChar(num: Char): Char {
        return num
    }

    // 原始字符串。在没有转义符的情况下，支持换行，展示效果与代码效果一致
    fun originalStringTest() {
        println("""我
            来
            换
            个
            行""")
    }

    // Array
    fun arrayTest() {
        var arr1 = arrayOf(1, 2, 3)
        var arr2 = intArrayOf(1, 2, 3)
        var arr3 = Array<String>(5, { index -> (index * index).toString() })// 下角标范围0..4
        println(Arrays.toString(arr3))
    }

    // 可变参数/可变数组
//    doInBackground("111", "222", "333")
//    doInBackground(*arrayOf("aaa", "bbb", "ccc"))// i注意arrayOf前面有*，这个叫伸展操作符
//    ---------------------
//    var arr = arrayOf(1,2,3)
//    doInBackground(0, *arr, 4)
    fun doInBackground(vararg params:String) {
        println(params)
    }

    // list（默认ArrayList）
    fun list() {
        val list1 = listOf<String>()// Kotlin独有的EmptyList
        val list2 = listOf("a", "b")// ArrayList
        val list3 = ArrayList<String>()
    }

}
