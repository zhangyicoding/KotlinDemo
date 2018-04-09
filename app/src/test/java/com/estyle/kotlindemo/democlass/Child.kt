package com.estyle.kotlindemo.democlass

/**
 * parent的子类。不可再被继承，相当于final
 * Kotlin：class Child，对应java：final class Child
 */
class Child(age: Int) : Parent(age), ChildInterface1, ChildInterface2 {

    // 自定义getter and setter不能使用lateinit。以下两种写法都正确
    // 写法一：强制不能赋默认值，我也不知道啥原因
    var childName: String?
        set(value) {
            childName = if (value == null) "" else value
        }
        get() = if (childName == null) "" else childName

    // 写法二：系统字段field，代表当前属性childName2，只在setter/getter中使用。
    // 强制必须有默认值，我也不知道啥原因
    var childName2: String? = null// 自动生成幕后字段field，并要求为field赋值
        set(value) {
            field = if (value == null) "" else value
        }
        get() = if (field == null) "" else field


    override fun eat() {
//        super.eat()// 只有父类或只有一个接口时
        super<Parent>.eat()
        super<ChildInterface1>.eat()
        super<ChildInterface2>.eat()
        print("parent name:${name}的孩子吃饭")
    }

}