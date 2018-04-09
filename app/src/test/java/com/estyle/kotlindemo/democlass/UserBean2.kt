package com.estyle.kotlindemo.democlass

/**
 * Created by zhangyi on 2018/4/2.
 */

class UserBean2 {

    constructor(account: String) {
        print("传统构造方法，值：${account}")
    }

    // 对比UserBean.kt。次构造必须【委托】主构造。所以UserBean.kt有局限性
    constructor(account: String, password: String) {
        print("传统构造方法，值：${account}, ${password}")
    }

    // 传统写法更加灵活
    constructor(userAge: Int) {
        print("另一个完全独立的构造，值：${userAge}")
    }
}
