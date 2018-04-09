package com.estyle.kotlindemo.democlass

/**
 * Created by zhangyi on 2018/3/30.
 */
data class UserBean(var account: String) {// 主构造方法，如果没有任何注解或可见性修饰符，可以省略constructor

    // 主构造方法不能有任何代码。初始化代码放在init中
    // 就算没有主构造方法，该初始化也会优先于constructor执行
    init {
        print("执行了init初始化代码块，主构造中的参数可以在这里用，账号：${account}")
    }

    // 次构造方法必须【委托】给主构造方法，此乃局限性。对比UserBean2.kt的不同参数构造方法吧
    constructor(account: String, password: String) : this(account) {
        print("次构造方法：值：${account}, ${password}")
    }

    // 注意！在有主构造的情况下，该写法错误。对比UserBean2.kt，传统写法还是有灵活性的
//    constructor(userAge:Int) {
//        print("哎，改写法压根就不对，程序都运行不了，没法打印")
//    }


}