package com.estyle.kotlindemo.democlass

/**
 * data class:纯粹保存数据的类，即POJO
 * 主构造的参数必须使用val或var修饰。且只比较主构造的值
 * 如果主构造的值相同，即认为两个pojo对象值相同，而不考虑其他属性
 *
 * var pojo1 = PurePOJO("sange")
 * var pojo2 = PurePOJO("sange")
 * pojo1.age = 1
 * pojo2.age = 2
 * println(pojo1 == pojo2)// 值，true
 * println(pojo1 === pojo2// 地址，false
 */
data class PurePOJO(var name: String?) {

    var age: Int = 0

}