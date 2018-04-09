package com.estyle.kotlindemo.democlass

/**
 * Created by zhangyi on 2018/4/3.
 */

class StaticBlock {

    // 默认构造方法。 Java-> public StaticBlock(){}
    init {
        print("执行构造方法")
    }

    // 静态代码块。Java-> static {}
    companion object {

        init {
            print("执行静态代码块")
        }
    }
}
