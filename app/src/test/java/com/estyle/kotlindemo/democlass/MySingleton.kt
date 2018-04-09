package com.estyle.kotlindemo.democlass

/**
 * object修饰的类是单例。对应Java的严格表达为：MySingleton.INSTANCE.sing()
 * 但是在.kt中，单例可以像Java的静态方法/属性一样使用。在kt中的单例：MySingleton.sing()
 * 等价于下面的Java单例
 */
object MySingleton {// kotlin的单例就这么点儿东西，完事了，当然也可以按Java的写法手写kotlin单例，那多麻烦

    fun sing() {
        println("单了个例")
    }

}

// Java只能手写单例：MySingleton.getInstance().sing();
//public class MySingleton {
//
//    private static MySingleton instance;
//
//    private MySingleton() {
//    }
//
//    public static MySingleton getInstance() {
//        if (instance == null) {
//            instance = new MySingleton();
//        }
//        return instance;
//    }
//
//    public void sing() {
//        System.out.println("单了个例");
//    }
//
//}