package com.estyle.kotlindemo.democlass

/**
 * Created by zhangyi on 2018/4/2.
 * 外部类嵌套内部类
 *
 * 修饰词：
 *
 * public：kotlin默认，整个工程都可访问
 * public void a() -> fun a()
 *
 * internal：当前module可访问。例如：整个工程中只有app module可访问。
 * void a() -> internal fun a()
 *
 * private和protected没有变化
 * private：当前类中可访问
 * protected：当前类和子类可访问
 */
class Outer {

    class StaticInner// 相当于静态内部类，不可访问外部类

    inner class Inner// 普通内部类，持有外部类的引用，可访问外部类

}
