package com.estyle.kotlindemo.democlass

class Constants {

    companion object {

        fun a() {
            print("伴生对象，伴随这个类产生的对象。不是严格的静态方法，而是Constants.Companion对象的方法-> Constants.Companion.a()")
        }

        @JvmStatic
        fun b() {
            print("这才是严格的静态方法。-> Constants.b()")
        }

        // 使用const修饰必须在companion object或object中
        const val Z: Int = 3// static final int Z = 3
    }

        var x: Int = 1// int x = 1
        val Y: Int = 2// final int Y = 2

}