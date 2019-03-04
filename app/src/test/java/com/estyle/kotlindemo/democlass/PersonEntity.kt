package com.estyle.kotlindemo.democlass

/**
 * Created by zhangyi on 2019/3/4.
 */
data class PersonEntity(var name: String, var age: Int, var gender: Boolean) {
    override fun equals(other: Any?): Boolean {
        if (other is PersonEntity) {
            if (name == other.name && age == other.age) {
                return true
            }
        }
        return false
    }
}