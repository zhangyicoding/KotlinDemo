package com.estyle.kotlindemo.democlass

/**
 * open修饰的class代表父类，可以被继承。
 * 无open修饰（也是默认）的class是不允许被继承的，见Child.kt
 * Kotlin：open class Parent。对应Java：class Parent
 *
 * 属性默认可以被子类使用
 * 方法默认是final，必须使用open修饰才能被子类重写
 */
open class Parent(age: Int) {

    var name: String = "daddy"

    // 默认对应Java的final void eat()。必须使用open才能被重写
    open fun eat() {
        print("parent name:${name}吃饭")
    }

}
